package dev.luan.cloud.networking.packet;

import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutCheckVersion(String version) implements Packet {
}