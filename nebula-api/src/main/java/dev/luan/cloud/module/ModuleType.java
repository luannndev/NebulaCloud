package dev.luan.cloud.module;

import java.io.Serializable;

public enum ModuleType implements Serializable {
    Proxy,
    Lobby,
    Server,
    ALL,
    CLOUD_ONLY;
}