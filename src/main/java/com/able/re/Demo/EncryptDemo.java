package com.able.re.Demo;

import com.utils.Decrypt;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-07-12
 */
public class EncryptDemo {

    public static void main(String[] args) {
        String params = 8565+";"+945726+";1";
        String ev = Decrypt.encrypt(params);
        System.out.println(ev);
    }
}
