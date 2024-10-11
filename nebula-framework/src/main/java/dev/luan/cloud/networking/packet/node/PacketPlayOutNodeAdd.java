package dev.luan.cloud.networking.packet.node;

import dev.luan.cloud.pipe.Packet;

import java.net.InetSocketAddress;

public record PacketPlayOutNodeAdd(String name, InetSocketAddress address, long memory,
                                   boolean connected) implements Packet {
}