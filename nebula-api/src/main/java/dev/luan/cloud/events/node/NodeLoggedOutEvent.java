package dev.luan.cloud.events.node;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.node.INode;
import lombok.Getter;

@Getter
public class NodeLoggedOutEvent extends Event {

    private final INode node;

    public NodeLoggedOutEvent(INode node) {
        this.node = node;
    }
}