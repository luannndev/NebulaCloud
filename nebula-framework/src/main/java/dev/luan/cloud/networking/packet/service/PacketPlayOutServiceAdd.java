package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import dev.luan.cloud.template.ITemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public record PacketPlayOutServiceAdd(String serviceName, int serviceId, int port, int maxPlayers, int memory,
                                      String node, String serviceGroup, List<String> templates,
                                      HashMap<String, Object> propertyCache) implements Packet {

    public Optional<ICloudServiceGroup> parsedServiceGroup() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceGroupProvider().getServiceGroupByName(serviceGroup);
    }

    public Optional<INode> parsedNode() {
        return NebulaAPI.getNebulaAPI().getProvider().getNodeProvider().getNodeByName(node);
    }

    public List<ITemplate> parsedTemplates() {
        return NebulaAPI.getNebulaAPI().getProvider().getTemplateProvider().getAllTemplates().stream().map(ITemplate::getName).filter(templates::contains).toList().stream().map(s -> NebulaAPI.getNebulaAPI().getProvider().getTemplateProvider().getTemplateByName(s).orElseGet(null)).toList();
    }
}