package com.relyy.algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * 回文字符串的判断
 *
 * @author cairuirui
 * @create 2018/10/15
 */
public class PalindromicSubStringDemo {
    public static void main(String[] args) {
        String str = "leghel";

        System.out.println(isPalindromicSubString(str));

    }

    public static boolean isPalindromicSubString(String string) {
        if (StringUtils.isNotEmpty(string)) {
            int length = string.length();
            char[] chars = string.toCharArray();
            int i = 0,j=length - 1;
            for (;i <= j; i++,j--){
                if (chars[i] != chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
