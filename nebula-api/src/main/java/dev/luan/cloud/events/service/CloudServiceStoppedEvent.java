package dev.luan.cloud.events.service;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import lombok.Getter;

@Getter
public class CloudServiceStoppedEvent extends Event {

    private final ICloudService cloudService;

    public CloudServiceStoppedEvent(ICloudService cloudService) {
        this.cloudService = cloudService;
    }
}