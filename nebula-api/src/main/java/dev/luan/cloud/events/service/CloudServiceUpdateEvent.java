package dev.luan.cloud.events.service;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import dev.luan.cloud.service.ServiceState;
import lombok.Getter;

@Getter
public class CloudServiceUpdateEvent extends Event {

    private final ICloudService cloudService;
    private final boolean locked;
    private final ServiceState serviceState;
    private final int onlinePlayers;
    private final long usedMemory;

    public CloudServiceUpdateEvent(ICloudService cloudService, boolean locked, ServiceState serviceState,
                                   int onlinePlayers, long usedMemory) {
        this.cloudService = cloudService;
        this.locked = locked;
        this.serviceState = serviceState;
        this.onlinePlayers = onlinePlayers;
        this.usedMemory = usedMemory;
    }
}