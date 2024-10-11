package dev.luan.cloud.networking.packet.group;

import dev.luan.cloud.NebulaAPI;
import dev.luan.cloud.pipe.Packet;
import dev.luan.cloud.service.group.ICloudServiceGroup;

import java.util.Optional;

public record PacketPlayOutGroupReload(String serviceGroup) implements Packet {

    public Optional<ICloudServiceGroup> parsedServiceGroup() {
        return NebulaAPI.getNebulaAPI().getProvider().getServiceGroupProvider().getServiceGroupByName(serviceGroup);
    }
}