package dev.luan.cloud.networking.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.Getter;

@Getter
public class NebulaClient {

    private final Bootstrap bootstrap;
    private final Channel channel;
    private final ChannelFuture channelFuture;

    public NebulaClient(String host, int port) {
        EventLoopGroup eventLoopGroup = Epoll.isAvailable() ? new EpollEventLoopGroup() : new NioEventLoopGroup();

        try {
            this.bootstrap = new Bootstrap()
                    .group(eventLoopGroup)
                    .channel(Epoll.isAvailable() ? EpollSocketChannel.class : NioSocketChannel.class)
                    .handler(new ChannelInitializer<>() {
                        @Override
                        protected void initChannel(Channel channel) {
                            channel.pipeline()
                                    .addLast("packet-decoder", new ObjectDecoder(ClassResolvers.cacheDisabled(getClass().getClassLoader())))
                                    .addLast("packet-encoder", new ObjectEncoder());
                        }
                    });
            this.channelFuture = this.bootstrap.connect(host, port).sync();
            this.channel = this.channelFuture.channel();
        } catch (Exception exception) {
            throw new IllegalStateException("Failed to start nebula-client", exception);
        }
    }
}