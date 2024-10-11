package dev.luan.cloud.events.player;

import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.event.Event;
import lombok.Getter;

@Getter
public class CloudPlayerQuitEvent extends Event {

    private final ICloudPlayer cloudPlayer;

    public CloudPlayerQuitEvent(ICloudPlayer cloudPlayer) {
        this.cloudPlayer = cloudPlayer;
    }
}