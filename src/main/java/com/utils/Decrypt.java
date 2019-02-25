package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
public class Decrypt {

    public static final String xorKeys = "ZHIHUISHU";

    public static String encrypt(String input){
        int num =0 ;
        String output ="";
        char[] array = input.toCharArray();
        for (int i=0; i<array.length; i++) {
            num = (array[i] ^ xorKeys.charAt(i % xorKeys.length()));
            output += Integer.toHexString(num);
        }
        return output;
    }

    public static void main(String[] args) {
        try {
            String prams = "\"141925381;1;2;386057;9158;2027869;1777454,1777455,1777448\"";
            //prams="110524799;0;3;213760;5975;2020119;";
            //prams = "110524799;1;3;213760;5975;2020119;518315";
            prams="6e737873617e6b716d6d73787c6779647d67687f7279647e617c";
            //prams="6c707c7f6e7b657167687d";
            //String input = "63707e7a6570657a6e68737b73617a657c66617d7c7061706871656a7d7c79637263736668797c7b6065607a646f7b7d";
            //List<String> list = decryptData(input);

           // System.out.print(Integer.parseInt(list.get(0)));
            System.out.print(decrypt(prams));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String convertStringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    public static List<Integer> decrypt(String ev) throws IllegalAccessException {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < ev.length(); i += 2) {
            String str = ev.substring(i, i + 2);
            char c = (char) (Integer.parseInt(str, 16) ^ xorKeys.charAt(i / 2 % xorKeys.length()));
            if (c >= '0' && c <= ';') {
                output.append(c);
            } else {
                throw new IllegalAccessException("Illegal character: " + c);
            }
        }
        try {
            String decrypt = output.toString();
            String[] split = decrypt.split(";");
            List<Integer> list = new ArrayList<Integer>(split.length);
            for (String s : split) {
                list.add(Integer.parseInt(s));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Illegal exception: " + e.getMessage());
        }
    }

    public static List<String> decryptData(String ev) throws IllegalAccessException {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < ev.length(); i += 2) {
            String str = ev.substring(i, i + 2);
            char c = (char) (Integer.parseInt(str, 16) ^ xorKeys.charAt(i / 2 % xorKeys.length()));
            if (c >= ',' && c <= ';') {
                output.append(c);
            } else {
                throw new IllegalAccessException("Illegal character: " + c);
            }
        }
        try {
            String decrypt = output.toString();
            String[] split = decrypt.split(";");
            List<String> list = new ArrayList<String>(split.length);
            for (int i=0; i<split.length; i++) {
                list.add(split[i]);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Illegal exception: " + e.getMessage());
        }
    }
}
