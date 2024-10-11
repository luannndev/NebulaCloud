package dev.luan.cloud.networking;

import dev.luan.cloud.networking.client.NebulaClient;
import lombok.SneakyThrows;

public class NebulaFramework {

    @SneakyThrows
    public static NebulaClient createClient(String host, int port) {
        return new NebulaClient(host, port);
    }
}
