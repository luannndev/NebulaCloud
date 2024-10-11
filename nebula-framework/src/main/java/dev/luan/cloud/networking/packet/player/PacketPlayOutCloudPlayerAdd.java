package dev.luan.cloud.networking.packet.player;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;

import java.net.InetSocketAddress;
import java.util.Optional;
import java.util.UUID;

public record PacketPlayOutCloudPlayerAdd(String username, UUID uniquedId, InetSocketAddress address, String value,
                                          String signature, String cloudService) implements Packet {

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(cloudService);
    }
}