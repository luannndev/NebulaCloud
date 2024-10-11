package dev.luan.cloud.networking.packet.node;

import dev.luan.cloud.pipe.Packet;

import java.net.InetSocketAddress;

public record PacketPlayOutCreateNode(String name, String key, InetSocketAddress address) implements Packet {
}