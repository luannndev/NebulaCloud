package dev.luan.cloud.networking.packet.player;

import dev.luan.cloud.pipe.Packet;

import java.net.InetSocketAddress;
import java.util.UUID;

public record PacketPlayOutCloudPlayerRegister(String username, UUID uniquedId, InetSocketAddress address, String value,
                                               String signature, String cloudService) implements Packet {
}
