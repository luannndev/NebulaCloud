package dev.luan.cloud;

import lombok.Getter;

public abstract class NebulaAPI {

    @Getter
    protected static NebulaAPI nebulaAPI;

    protected NebulaAPI() {
        nebulaAPI = this;
    }


}
