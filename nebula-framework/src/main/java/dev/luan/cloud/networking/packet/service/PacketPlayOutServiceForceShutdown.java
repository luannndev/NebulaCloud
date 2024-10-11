package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;

import java.util.Optional;

public record PacketPlayOutServiceForceShutdown(String serviceName) implements Packet {

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(serviceName);
    }
}