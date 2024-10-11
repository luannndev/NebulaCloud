package dev.luan.cloud.networking.packet.player;

import dev.luan.cloud.pipe.Packet;

import java.util.UUID;

public record PacketPlayOutCloudPlayerDisconnect(UUID cloudPlayer, String message) implements Packet {
}