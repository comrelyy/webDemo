package com.able.re.jdk8demo.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-04-03
 */
public class DateDemo {

    public static void main(String[] args) {

        /**
         * 1，获取当天的日期,时间
         */
        LocalDate today = LocalDate.now();
        System.out.println("Today’s Local date is " + today);
        LocalTime time = LocalTime.now();
        System.out.println("Now Local time is " + time);
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current Local time is " + current);
        /**
         * 2 获取当前的年月日
         */
        int year = today.getYear();
        //Month month = today.getMonth();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month: %d Day: %d \t %n",year,month,day);

        /**
         * 3,获取某个特定的日期
         */
        LocalDate localDate = LocalDate.of(2008, 8, 8);
        System.out.println("The special Local date is " + localDate);

        /**
         * 4 检查日期相等
         */
        LocalDate date1 = LocalDate.of(2018, 4, 3);
        System.out.println("localDate is today:"+today.equals(localDate));
        System.out.println("date1 is today:"+today.equals(date1));
    }
}
