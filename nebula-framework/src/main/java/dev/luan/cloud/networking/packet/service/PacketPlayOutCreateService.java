package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import dev.luan.cloud.template.ITemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public record PacketPlayOutCreateService(String serviceName, int serviceId, int port, int maxPlayers, int memory,
                                         String node, String serviceGroup, List<String> templates,
                                         HashMap<String, Object> propertyCache, String type) implements Packet {

    public Optional<ICloudServiceGroup> parsedServiceGroup() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceGroupProvider().getServiceGroupByName(serviceGroup);
    }

    public Optional<INode> parsedNode() {
        return NebulaAPI.getNebulaAPI().getProvider().getNodeProvider().getNodeByName(node);
    }

    public List<ITemplate> parsedTemplates() {
        List<ITemplate> templateList = new ArrayList<>();
        templates.forEach(template -> {
            templateList.add(NebulaAPI.getNebulaAPI().getProvider().getTemplateProvider().getTemplateByName(template).orElseGet(null));
        });
        return templateList;
    }
}