package dev.luan.cloud.networking.packet.group;

import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.ServiceType;

import java.util.List;

public record PacketPlayOutGroupAdd(String name, String groupTitle, String node,
                                    List<String> templates, ServiceType serviceType, String version,
                                    boolean maintenance, boolean isStatic, boolean hasPort, int port,
                                    int maximumPlayers, int memory, int minimalServices,
                                    int maximalServices) implements Packet {
}