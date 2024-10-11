package dev.luan.cloud.networking.packet.console;

import dev.luan.cloud.console.LogType;
import dev.luan.cloud.pipe.Packet;

public record PacketPlayOutSendConsole(String message, LogType logType) implements Packet {
}
