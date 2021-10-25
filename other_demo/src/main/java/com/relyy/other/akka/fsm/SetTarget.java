package com.relyy.other.akka.fsm;

import akka.actor.ActorRef;

public final class SetTarget {

    private final ActorRef ref;

    public SetTarget(ActorRef ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "SetTarget{" +
                "ref=" + ref +
                '}';
    }
}
