package com.able.re.jdk8demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * jdk8 lambda 表达式学习
 *
 * @author cairuirui
 * @create 2018-01-13
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //String newStr = toUpperString((str) -> str.toUpperCase(),"ytiuhoiho");
        String newStr = toUpperString(String::toUpperCase,"ytiuhoiho");
        System.out.println(newStr);
        //sys(x -> System.out.println(x),"love");
        //sys(System.out::println,"love");

    }

    public static String toUpperString(MyFunc<String> mf,String str){
        return mf.getValue(str);
    }

    public static void sys(Consumer<String> consumer, String str){
        consumer.accept(str);
    }

}
