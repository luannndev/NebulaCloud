package dev.luan.cloud.events.group;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import lombok.Getter;

@Getter
public class CloudGroupCreatedEvent extends Event {

    private final ICloudServiceGroup cloudServiceGroup;

    public CloudGroupCreatedEvent(ICloudServiceGroup cloudServiceGroup) {
        this.cloudServiceGroup = cloudServiceGroup;
    }
}