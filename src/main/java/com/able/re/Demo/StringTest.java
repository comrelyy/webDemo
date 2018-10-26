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

        String illegalChar = "可以chou\'a\"ho\'su\"houboHOhonfoh";
//
//        String regex = "^[0-9]$";
//        boolean matches = Pattern.matches(regex, illegalChar.substring(0,1));
//        if (!matches) {
//            System.out.println("没有匹配上");
//        }else {
//            System.out.println("匹配上");
//        }
        System.out.println(illegalChar.indexOf("\'"));
        System.out.println(illegalChar.indexOf("\""));
        illegalChar = illegalChar.replace("\'","*");
        System.out.println(illegalChar);
        illegalChar = illegalChar.replace("\"","*");

        System.out.println(illegalChar);

        Object object = null;
        System.out.println(object+"");

        String userQuestionAnswerDataRelationCacheKey = getUserQuestionAnswerDataRelationCacheKey(182352370L, 384496, 8999, 1772537);
        System.out.println(userQuestionAnswerDataRelationCacheKey);

        String answer = "aoauho我是答案";
        System.out.println(answer.indexOf("<p><br></p>"));
        String replace = answer.replace("<p><br></p>", "");
        System.out.println(replace.length());

        String s = "abc";
        String newS = new String("abc");
        System.out.println(s.hashCode()+"--------"+ newS.hashCode());

        System.out.println("1,2,5".contains("1"));

        String lists = "[432287, 432288, 432289, 432290, 432291]";
        String[] ssssplit = lists.replace("[", "").replace("]", "").split(", ");
        for (String s1 : ssssplit) {
            System.out.println(Integer.valueOf(s1));
        }
    }

    public static String getUserQuestionAnswerDataRelationCacheKey(Long userId,Integer examId,Integer recruitId, Integer questionId) {
        return String.format("%s:%s:%s:%s", userId, examId, recruitId, questionId);
    }
}
