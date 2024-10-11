package dev.luan.cloud.networking.packet.group;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.template.ITemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record PacketPlayOutCreateProxyGroup(String name, String groupTitle, String node,
                                            List<String> templates,
                                            String version, boolean maintenance, boolean isStatic, int port,
                                            int maximumPlayers,
                                            int memory, int minimalServices, int maximalServices) implements Packet {

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