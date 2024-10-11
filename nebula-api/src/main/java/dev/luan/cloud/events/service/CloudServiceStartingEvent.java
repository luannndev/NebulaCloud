package dev.luan.cloud.events.service;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import lombok.Getter;

@Getter
public class CloudServiceStartingEvent extends Event {

    private final ICloudService cloudService;

    public CloudServiceStartingEvent(ICloudService cloudService) {
        this.cloudService = cloudService;
    }
}