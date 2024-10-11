package dev.luan.cloud.networking.packet.player;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ICloudService;

import java.util.Optional;
import java.util.UUID;

public record PacketPlayOutCloudPlayerConnect(UUID cloudPlayer, String cloudService) implements Packet {

    public Optional<ICloudPlayer> parsedCloudPlayer() {
        return NebulaAPI.getNebulaAPI().getProvider().getCloudPlayerProvider().getCloudPlayer(cloudPlayer);
    }

    public Optional<ICloudService> parsedCloudService() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceProvider().getServiceByName(cloudService);
    }
}