package com.able.re.Demo;

/**
 * 字符串测试类
 *
 * @author cairuirui
 * @date 2017-12-28
 */
public class StringTest {

    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder();

        sb1.append("a").append("b").append("q").append("f");
        System.out.println(sb1.toString());
        String str1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder(str1);
        sb2.append("c");
        System.out.println("sb2======="+sb2.toString());
        System.out.println("sb1======="+sb1.toString());
        System.out.println("str1======="+str1);
    }
}
