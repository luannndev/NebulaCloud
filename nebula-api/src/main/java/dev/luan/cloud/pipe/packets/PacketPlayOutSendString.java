package dev.luan.cloud.pipe.packets;

import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutSendString(String string) implements Packet {
}
