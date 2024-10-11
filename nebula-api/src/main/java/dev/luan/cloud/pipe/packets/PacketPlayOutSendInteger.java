package dev.luan.cloud.pipe.packets;

import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutSendInteger(int integer) implements Packet {
}
