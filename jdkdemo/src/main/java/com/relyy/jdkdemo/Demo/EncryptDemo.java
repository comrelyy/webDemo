package com.relyy.jdkdemo.Demo;

import com.utils.Decrypt;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-12
 */
public class EncryptDemo {

    public static void main(String[] args) {
        String params = "7862;1020510;0;193101545";
        String ev = Decrypt.encrypt(params);
        System.out.println(ev);
    }
}
