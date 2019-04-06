package com.able.re.Demo;


import java.util.ArrayList;
import java.util.List;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/4/2
 */
public class ObjectReferenceDemo {

    public static void main(String[] args) {
       List<Integer> integers = new ArrayList<>();
       listAdd(integers);
        System.out.println(integers);
    }

   public static void listAdd(List<Integer> integers){
       integers.add(1);
        System.out.println(integers);
    }
}
