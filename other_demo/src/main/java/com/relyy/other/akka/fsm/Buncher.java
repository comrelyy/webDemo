package com.relyy.other.akka.fsm;

import akka.actor.AbstractFSM;

public class Buncher extends AbstractFSM<State,Data> {
    {
        startWith(com.relyy.other.akka.fsm.State.Idle, Uninitialized.UNINITIALIZED);
        when(com.relyy.other.akka.fsm.State.Idle,matchEvent(SetTarget.class));
    }

}