package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;

import java.util.HashMap;
import java.util.Optional;

public record PacketPlayOutServiceAddProperties(String serviceName,
                                                HashMap<String, Object> propertiesCache) implements Packet {

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(serviceName);
    }
}