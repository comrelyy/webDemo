package com.relyy.jdkdemo.Demo;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/10/26
 */
public class ArrayDemo {

    public static void main(String[] args) {
        String[] strings = new String[5];
        System.out.println(getCount(strings));
    }

    public static int getCount(String[] strings){
        int count = 0;
        for (String string : strings) {
            count++;
        }
        return count;
    }
}
