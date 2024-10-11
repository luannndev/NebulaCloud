package dev.luan.cloud.events.service;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.service.ICloudService;
import lombok.Getter;

import java.nio.file.Path;

@Getter
public class CloudServiceCopyEvent extends Event {

    private final ICloudService cloudService;
    private final Path template;

    public CloudServiceCopyEvent(ICloudService cloudService, Path template) {
        this.cloudService = cloudService;
        this.template = template;
    }
}