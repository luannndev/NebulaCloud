package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.node.INode;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;

import java.util.Optional;

public record PacketPlayOutSuccessfullyServiceStarted(String serviceName, String node) implements Packet {

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(serviceName);
    }

    public Optional<INode> parsedNode() {
        return NebulaAPI.getNebulaAPI().getProvider().getNodeProvider().getNodeByName(node);
    }
}