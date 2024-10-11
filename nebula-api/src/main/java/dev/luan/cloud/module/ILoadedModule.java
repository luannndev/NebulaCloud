package dev.luan.cloud.module;

import java.io.Serializable;

public interface ILoadedModule extends Serializable {

    String getName();

    String getFileName();

    String getAuthor();

    String getVersion();

    String getDescription();

    String getMainClass();

    boolean isReloadable();

    ModuleType getModuleType();
}