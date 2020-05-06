package com.able.re.Demo;

public class SubDemo {

    private String name = "sub";

    public SubDemo(){
        callName();
    }

    public void callName(){
        System.out.println(name);
    }

    static class ChildDemo extends SubDemo{
        private String name = "child";

        @Override
        public void callName(){
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        SubDemo sub = new ChildDemo();
        System.out.println(sub);
    }
}
