package dev.luan.cloud.pipe.packets;

import dev.luan.cloud.pipe.Packet;

import java.util.HashMap;

public record PacketPlayOutSendHashMap(HashMap<String, Object> hashMap) implements Packet {
}
