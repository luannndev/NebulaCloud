package dev.luan.cloud.networking.packet.player;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.pipe.Packet;

import java.util.Optional;
import java.util.UUID;

public record PacketPlayOutCloudPlayerJoin(UUID cloudPlayer) implements Packet {

    public Optional<ICloudPlayer> parsedCloudPlayer() {
        return NebulaAPI.getNebulaAPI().getProvider().getCloudPlayerProvider().getCloudPlayer(cloudPlayer);
    }
}