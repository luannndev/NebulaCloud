package dev.luan.cloud.service.impl;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.networking.packet.service.PacketPlayOutServiceShutdown;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.service.ICloudService;
import dev.luan.cloud.service.ServiceState;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import dev.luan.cloud.template.ITemplate;

import java.util.HashMap;
import java.util.List;

public class CloudService implements ICloudService {

    private final String serviceName;
    private final int serviceId;
    private final int port;
    private final INode node;
    private final ICloudServiceGroup iCloudServiceGroup;
    private final List<ITemplate> templates;
    private final HashMap<String, Object> propertyCache;
    private int onlinePlayers;
    private long usedMemory;
    private boolean locked;
    private ServiceState serviceState;

    public CloudService(String serviceName, int serviceId, int port, INode node, ICloudServiceGroup iCloudServiceGroup, List<ITemplate> templates) {
        this(serviceName, serviceId, port, node, iCloudServiceGroup, templates != null ? templates : iCloudServiceGroup.getTemplates(), false);
    }

    public CloudService(String serviceName, int serviceId, int port, int memory, INode node, ICloudServiceGroup iCloudServiceGroup, List<ITemplate> templates, HashMap<String, Object> propertyCache) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.port = port;
        this.node = node;
        this.iCloudServiceGroup = iCloudServiceGroup;
        this.templates = templates;
        this.onlinePlayers = 0;
        this.usedMemory = memory;
        this.serviceState = ServiceState.PREPARING;
        this.propertyCache = propertyCache;
    }

    public CloudService(String serviceName, int serviceId, int port, int memory, INode node, ICloudServiceGroup iCloudServiceGroup, List<ITemplate> templates) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.port = port;
        this.node = node;
        this.iCloudServiceGroup = iCloudServiceGroup;
        this.templates = templates;
        this.onlinePlayers = 0;
        this.usedMemory = memory;
        this.serviceState = ServiceState.PREPARING;
        this.propertyCache = new HashMap<>();
    }

    public CloudService(String serviceName, int serviceId, int port, INode node, ICloudServiceGroup iCloudServiceGroup, List<ITemplate> templates, boolean online) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.port = port;
        this.node = node;
        this.iCloudServiceGroup = iCloudServiceGroup;
        this.templates = templates;
        this.onlinePlayers = 0;
        this.usedMemory = 0;
        this.serviceState = online ? ServiceState.ONLINE : ServiceState.PREPARING;
        this.propertyCache = new HashMap<>();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getServiceId() {
        return serviceId;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public List<ITemplate> getTemplates() {
        return templates;
    }

    @Override
    public int getOnlinePlayers() {
        return onlinePlayers;
    }

    @Override
    public void setOnlinePlayers(int onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    @Override
    public long getUsedMemory() {
        return usedMemory;
    }

    @Override
    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    @Override
    public void update() {
      //  NebulaAPI.getNebulaAPI().getProvider().getNebulaNetworking().sendPacket(new PacketPlayOutUpdateService(getServiceName(), getOnlinePlayers(), getUsedMemory(), getServiceState(), isLocked(), getPropertyMap()));
    }

    @Override
    public ICloudServiceGroup getServiceGroup() {
        return iCloudServiceGroup;
    }

    @Override
    public INode getServiceNode() {
        return node;
    }

    @Override
    public ServiceState getServiceState() {
        return serviceState;
    }

    @Override
    public void setServiceState(ServiceState serviceState) {
        this.serviceState = serviceState;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public void addProperty(String name, Object property) {
        this.propertyCache.put(name, property);
    }

    @Override
    public void removeProperty(String name) {
        this.propertyCache.remove(name);
    }

    @Override
    public Object getProperty(String name) {
        return this.propertyCache.get(name);
    }

    @Override
    public HashMap<String, Object> getPropertyMap() {
        return propertyCache;
    }

    @Override
    public void shutdown() {
        NebulaAPI.getNebulaAPI().getProvider().getNebulaNetworking().sendPacket(new PacketPlayOutServiceShutdown(getServiceName(), getServiceNode().getName()));
    }
}