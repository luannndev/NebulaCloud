package dev.luan.cloud.events.player;

import dev.luan.cloud.entity.ICloudPlayer;
import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import lombok.Getter;

@Getter
public class CloudPlayerServiceConnectEvent extends Event {

    private final ICloudPlayer cloudPlayer;
    private final ICloudService newService;

    public CloudPlayerServiceConnectEvent(ICloudPlayer cloudPlayer, ICloudService newService) {
        this.cloudPlayer = cloudPlayer;
        this.newService = newService;
    }
}