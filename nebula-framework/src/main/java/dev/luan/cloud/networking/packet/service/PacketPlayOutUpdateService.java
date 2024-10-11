package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;
import dev.luan.cloud.service.ServiceState;

import java.util.HashMap;
import java.util.Optional;

public record PacketPlayOutUpdateService(String serviceName, int players, double memory, ServiceState serviceState,
                                         boolean locked, HashMap<String, Object> propertyCache) implements Packet {

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(serviceName);
    }
}