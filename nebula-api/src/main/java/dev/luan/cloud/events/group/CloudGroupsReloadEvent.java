package dev.luan.cloud.events.group;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.group.ICloudServiceGroup;
import lombok.Getter;

import java.util.List;

@Getter
public class CloudGroupsReloadEvent extends Event {

    private final List<ICloudServiceGroup> serviceGroups;

    public CloudGroupsReloadEvent(List<ICloudServiceGroup> serviceGroups) {
        this.serviceGroups = serviceGroups;
    }
}