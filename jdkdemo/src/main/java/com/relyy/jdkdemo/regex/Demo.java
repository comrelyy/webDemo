package com.relyy.jdkdemo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/10/24
 */
public class Demo {

    public static void main(String[] args) {
//        String s = "18317056746";
//        testPhonenum(s);

            //String s = "relyy2014@163.com";
            //String s = "962615438@qq.com";
//            String s = "cairuirui@able-elec.com";
//            testEmail(s);

        String s = "abb";
        testFirstWords(s);
    }

    public static void  testEmail(String email){
        String regEx = "^[a-zA-Z_]{0,}[0-9]{0,}@([a-zA-Z0-9-]+\\.){1,3}[a-zA-Z]{2,}$";
        Pattern compile = Pattern.compile(regEx);
        System.out.println(compile.matcher(email).matches());
    }

    public static void testPhonenum(String phonenum){
        String regEx = "^1[3578][0-9]{9}$";
        Pattern compile = Pattern.compile(regEx);
        System.out.println(compile.matcher(phonenum).matches());
    }

    public static void testFirstWords(String s){
        //String regEx = "\\b(\\w+)\\b\\s+\\1\\b";  //匹配 go go
        String regEx = "a.*b";
        Pattern compile = Pattern.compile(regEx);
        Matcher matcher = compile.matcher(s);
        System.out.println(matcher);
        System.out.println(matcher.matches());
    }
}
