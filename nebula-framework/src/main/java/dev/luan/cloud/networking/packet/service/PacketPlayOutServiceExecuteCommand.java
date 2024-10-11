package dev.luan.cloud.networking.packet.service;

import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutServiceExecuteCommand(String cloudService, String command) implements Packet {
}