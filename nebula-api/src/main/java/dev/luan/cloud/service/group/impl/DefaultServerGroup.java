package dev.luan.cloud.service.group.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.networking.packet.group.PacketPlayOutGroupUpdate;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.service.ServiceType;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import dev.luan.cloud.template.ITemplate;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultServerGroup implements ICloudServiceGroup {

    private final String name;
    private final String groupTitle;
    private final List<ITemplate> templates;
    private final ServiceType cloudServiceType = ServiceType.Server;
    private INode node;
    private String version;
    private int maximumPlayers;
    private boolean maintenance;
    private boolean isStatic;
    private int memory;
    private int minimalServices;
    private int maximalServices;

    @SneakyThrows
    public DefaultServerGroup(String name, String groupTitle, INode node, List<ITemplate> templates, String version, boolean maintenance, boolean isStatic, int maximumPlayers, int memory, int minimalServices, int maximalServices) {
        this.name = name;
        this.groupTitle = groupTitle;
        this.node = node;
        this.templates = templates;
        this.version = version;
        this.maintenance = maintenance;
        this.isStatic = isStatic;
        this.maximumPlayers = maximumPlayers;
        this.memory = memory;
        this.minimalServices = minimalServices;
        this.maximalServices = maximalServices;
    }

    public ICloudServiceGroup initFile() {
        final JsonObject json = new JsonObject();
        final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final JsonArray templateArray = new JsonArray();
        templates.forEach(template -> templateArray.add(template.getName()));

        json.addProperty("group_name", name);
        json.addProperty("group_title", groupTitle);
        json.addProperty("node", node.getName());
        json.add("templates", templateArray);
        json.addProperty("version", version);
        json.addProperty("servicetype", cloudServiceType.name());
        json.addProperty("maintenance", maintenance);
        json.addProperty("static", isStatic);
        json.addProperty("maximum_players", maximumPlayers);
        json.addProperty("memory", memory);
        json.addProperty("minimal_services", minimalServices);
        json.addProperty("maximal_services", maximalServices);

        executorService.execute(() -> {
            try (final OutputStreamWriter writer = new OutputStreamWriter(Files.newOutputStream(new File("groups/" + name + ".json").toPath()), StandardCharsets.UTF_8)) {
                gson.toJson(json, writer);
            } catch (IOException ignored) {
            }
        });
        return this;
    }

    @Override
    public String getGroupName() {
        return name;
    }

    @Override
    public String getGroupTitle() {
        return groupTitle;
    }

    @Override
    public INode getGroupNode() {
        return node;
    }

    @Override
    public void setGroupNode(INode node) {
        this.node = node;
    }

    @Override
    public List<ITemplate> getTemplates() {
        return templates;
    }

    @Override
    public ServiceType getServiceType() {
        return cloudServiceType;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public boolean isStatic() {
        return isStatic;
    }

    @Override
    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    @Override
    public boolean hasPort() {
        return false;
    }

    @Override
    public int getPort() {
        return -1;
    }

    @Override
    public int getMaxPlayers() {
        return maximumPlayers;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public int getMinServices() {
        return minimalServices;
    }

    @Override
    public void setMinServices(int services) {
        this.minimalServices = services;
    }

    @Override
    public int getMaxServices() {
        return maximalServices;
    }

    @Override
    public void setMaxServices(int services) {
        this.maximalServices = services;
    }

    @Override
    public void setMaxPlayer(int players) {
        this.maximumPlayers = players;
    }

    @Override
    public void update() {
        NebulaAPI.getNebulaAPI().getProvider().getNebulaNetworking().sendPacket(new PacketPlayOutGroupUpdate(getGroupName(), node.getName(), version, maximumPlayers, maintenance, isStatic, memory, minimalServices, maximalServices));
    }
}