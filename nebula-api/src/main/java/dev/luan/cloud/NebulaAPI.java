package dev.luan.cloud;

import dev.luan.cloud.api.ICloudFactory;
import dev.luan.cloud.api.ICloudProvider;
import lombok.Getter;

public abstract class NebulaAPI {

    @Getter
    protected static NebulaAPI nebulaAPI;

    protected NebulaAPI() {
        nebulaAPI = this;
    }

    public abstract ICloudProvider getProvider();

    public abstract ICloudFactory getFactory();
}
