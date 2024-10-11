package dev.luan.cloud.events.group;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import lombok.Getter;

@Getter
public class CloudGroupUpdatedEvent extends Event {

    private final ICloudServiceGroup cloudServiceGroup;

    public CloudGroupUpdatedEvent(ICloudServiceGroup cloudServiceGroup) {
        this.cloudServiceGroup = cloudServiceGroup;
    }
}