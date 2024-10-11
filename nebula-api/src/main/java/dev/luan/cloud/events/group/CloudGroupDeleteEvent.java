package dev.luan.cloud.events.group;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import lombok.Getter;

@Getter
public class CloudGroupDeleteEvent extends Event {

    private final ICloudServiceGroup cloudServiceGroup;

    public CloudGroupDeleteEvent(ICloudServiceGroup cloudServiceGroup) {
        this.cloudServiceGroup = cloudServiceGroup;
    }
}