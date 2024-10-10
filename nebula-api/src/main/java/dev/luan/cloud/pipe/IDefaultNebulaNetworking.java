package dev.luan.cloud.pipe;

import io.netty.channel.Channel;

public interface IDefaultNebulaNetworking {

    String getHostAddress();

    int getPort();

    Channel getChannel();

    void addHandler(Handler handler);

    void sendPacket(Packet packet);
}