package dev.luan.cloud.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import dev.luan.cloud.template.ITemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ServiceBuilder {

    private final String serviceName;
    private final int serviceId;
    private final HashMap<String, Object> propertyCache;
    private ICloudServiceGroup serviceGroup;
    private List<ITemplate> templates;
    private int maximumPlayers;
    private int maxMemory;

    public ServiceBuilder(String serviceName, int serviceId) {
        this.serviceName = serviceName;
        this.serviceId = serviceId;
        this.propertyCache = new HashMap<>();
    }

    public ServiceBuilder setServiceGroup(ICloudServiceGroup serviceGroup) {
        this.serviceGroup = serviceGroup;
        return this;
    }

    public ServiceBuilder addTemplate(ITemplate template) {
        if (templates == null)
            templates = new LinkedList<>();

        templates.add(template);
        return this;
    }

    public ServiceBuilder setMaximumPlayers(int maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
        return this;
    }

    public ServiceBuilder setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
        return this;
    }

    public ServiceBuilder addProperty(String name, Object property) {
        this.propertyCache.put(name, property);
        return this;
    }

    public ServiceBuilder removeProperty(String name) {
        this.propertyCache.remove(name);
        return this;
    }

    public void build() {
        if (serviceName == null)
            throw new NullPointerException("service name cannot be null");
        if (serviceGroup == null)
            throw new NullPointerException("cloud service group cannot be null");
        if (templates == null)
            templates = new LinkedList<>();

        NebulaAPI.getNebulaAPI().getFactory().getServiceFactory().createService(serviceName, serviceGroup, templates, serviceId, maximumPlayers == 0 ? serviceGroup.getMaxPlayers() : maximumPlayers, maxMemory == 0 ? serviceGroup.getMaxPlayers() : maxMemory, propertyCache);
    }
}