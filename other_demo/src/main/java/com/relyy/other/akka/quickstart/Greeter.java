package com.relyy.other.akka.quickstart;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class Greeter extends AbstractActor {

    private final String message;
    private final ActorRef printerActor;

    private String greeting = "";

    public Greeter(String message, ActorRef printerActor) {
        this.message = message;
        this.printerActor = printerActor;
    }


    static public Props props(String message, ActorRef printerActor){
        return Props.create(Greeter.class,() -> new Greeter(message,printerActor));
    }

    /**
     * actor 启动之后在处理其第一条消息之前调用
     * @throws Exception
     */
    @Override
    public void preStart() throws Exception {
        super.preStart();
    }

    /**
     * actor停止之前调用，在此之后不再处理任何消息
     * @throws Exception
     */
    @Override
    public void postStop() throws Exception {
        super.postStop();
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WhoToGreet.class,wtg -> {
                    this.greeting = message + "," + wtg.who;
                })
                .match(Greet.class,x -> {
                    printerActor.tell(new Printer.Greeting(greeting),getSelf());
                })
                .build();
    }

    static public class WhoToGreet{
        public final String who;


        public WhoToGreet(String who) {
            this.who = who;
        }
    }

    static public class Greet{
        public Greet() {
        }
    }

}
