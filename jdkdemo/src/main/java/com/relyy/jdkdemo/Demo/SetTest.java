package com.relyy.jdkdemo.Demo;

import java.util.HashSet;
import java.util.Set;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-08-13
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        System.out.println(set.add("a"));
        System.out.println(set.add("a"));
    }
}
