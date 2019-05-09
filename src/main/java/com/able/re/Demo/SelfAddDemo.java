package com.able.re.Demo;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/4/10
 */
public class SelfAddDemo {

    public static void main(String[] args) {
        int i = 0;
        int a = 0;
        for (int j = 0 ; j<100; j++){
            System.out.println(j+"-----"+i);
            System.out.println(a);
            i = i++;
        }
        System.out.println(a);
        i = 5;
        int z = ++i + i++;
        System.out.println(z);
        System.out.println(i);
    }
}
