package dev.luan.cloud.events.node;

import dev.luan.cloud.event.Event;
import dev.luan.cloud.node.INode;
import lombok.Getter;

@Getter
public class NodeLoggedInEvent extends Event {

    private final INode node;

    public NodeLoggedInEvent(INode node) {
        this.node = node;
    }
}