package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutCopyServiceToTemplate(String service, String template) implements Packet {
}