package com.able.re.Demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-05-28
 */
public class ArrayListDemo {

    public static void main(String[] args) {
//        ArrayList<Object> objects = new ArrayList<>(10);
//        String abc = null;
//        //System.out.println(objects.add("a"));
//        System.out.println(objects.size());
////        System.out.println(objects.isEmpty());
////        System.out.println(objects.set(2,"a"));
////        System.out.println(objects.indexOf(abc));
////        System.out.println(objects.lastIndexOf(abc));
//        String abcp[] = new String[10];
//        int i = 0;
//        System.out.println(abcp.length);
//        abcp[i++]="a";
//        System.out.println(i);
//        System.out.println(abcp[i]);

        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);
        integers.add(11);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        integers.add(17);
        integers.add(15);
        integers.add(16);
        int size = integers.size();
        System.out.println(integers.toString().replace("[", "").replace("]", ""));
        //System.out.println(new Random().nextInt(size));
//        Iterator<Integer> it = integers.iterator();
//        while (it.hasNext()){
//            Integer next = it.next();
//            if (next % 2 == 0){
//                //it.remove();
//                integers.remove(next);
//            }
//        }
        //System.out.println(integers.indexOf(16));
        //integers.contains()
//        for (Integer num : integers) {
//            if (num % 2 == 0){
//                integers.remove(num);
//            }
//        }
//
//        for (int i = 0; i < integers.size(); i++){
//            if (integers.get(i) % 2 == 0) {
//                integers.remove(i);
//            }
//        }

    }
}
