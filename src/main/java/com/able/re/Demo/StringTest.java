package com.able.re.Demo;

import java.io.Console;
import java.util.regex.Pattern;

/**
 * 字符串测试类
 *
 * @author cairuirui
 * @date 2017-12-28
 */
public class StringTest {

    public static void main(String[] args) {

//        StringBuilder sb1 = new StringBuilder();
//
//        sb1.append("a").append("b").append("q").append("f");
//        System.out.println(sb1.toString());
//        String str1 = sb1.toString();
//        StringBuilder sb2 = new StringBuilder(str1);
//        sb2.append("c");
//        System.out.println("sb2======="+sb2.toString());
//        System.out.println("sb1======="+sb1.toString());
//        System.out.println("str1======="+str1);
//        System.out.println(System.currentTimeMillis());


        //TestNull test = new TestNull();

        String illegalChar = ",";

        String regex = "^[0-9]$";
        boolean matches = Pattern.matches(regex, illegalChar.substring(0,1));
        if (!matches) {
            System.out.println("没有匹配上");
        }else {
            System.out.println("匹配上");
        }

    }
}
