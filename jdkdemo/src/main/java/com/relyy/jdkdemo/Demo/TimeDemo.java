package com.relyy.jdkdemo.Demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2019/1/25
 */
public class TimeDemo {

    public static void main(String[] args) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String time = "2019-01-26 17:00:00";
        Date date = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse("2019-01-26 17:00:00");

//        System.out.println(date.getTime());
//        System.out.println(format.format(new Date()));
//        System.out.println(new Date().getTime());
        while (true) {
            System.out.println((1548410000000L - (new Date()).getTime()) / 1000);
            Thread.sleep(1123);
        }

    }
}
