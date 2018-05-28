package com.able.re.Demo;

import java.util.ArrayList;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-05-28
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>(10);
        String abc = null;
        //System.out.println(objects.add("a"));
        System.out.println(objects.size());
//        System.out.println(objects.isEmpty());
//        System.out.println(objects.set(2,"a"));
//        System.out.println(objects.indexOf(abc));
//        System.out.println(objects.lastIndexOf(abc));
        String abcp[] = new String[10];
        int i = 0;
        System.out.println(abcp.length);
        abcp[i++]="a";
        System.out.println(i);
        System.out.println(abcp[i]);

    }
}
