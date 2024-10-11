package dev.luan.cloud.events.player;

import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import lombok.Getter;

@Getter
public class CloudPlayerServiceConnectedEvent extends Event {

    private final ICloudPlayer cloudPlayer;
    private final ICloudService cloudService;

    public CloudPlayerServiceConnectedEvent(ICloudPlayer cloudPlayer, ICloudService cloudService) {
        this.cloudPlayer = cloudPlayer;
        this.cloudService = cloudService;
    }
}