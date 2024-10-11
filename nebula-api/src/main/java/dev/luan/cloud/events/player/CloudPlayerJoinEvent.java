package dev.luan.cloud.events.player;

import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.event.Event;
import lombok.Getter;

@Getter
public class CloudPlayerJoinEvent extends Event {

    private final ICloudPlayer cloudPlayer;

    public CloudPlayerJoinEvent(ICloudPlayer cloudPlayer) {
        this.cloudPlayer = cloudPlayer;
    }
}