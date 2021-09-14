package com.relyy.algorithm.String;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * List<String>中元素都为单词</>
 * 程序要求：
 * 1 有相同字母的单词分为一组，字母顺序可以不同
 * 2 单词不去重
 *
 * @author cairuirui
 * @create 2019/3/26
 */
public class GroupWords {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("able");
        strings.add("aebl");
        strings.add("bale");
        strings.add("cretae");
        strings.add("create");
        strings.add("to");
        strings.add("do");
        groupWords(strings);

    }

    public static void groupWords(List<String> strings){
        String charDir="abcdefghijklmnopqrstuvwxyz";
        Map<Integer,List<String>> map = new HashMap<>();
        if (CollectionUtils.isNotEmpty(strings)) {
            for (String s : strings) {
                String lowerCase = s.toLowerCase();
                char[] chars = lowerCase.toCharArray();
                Integer value = 0;
                for (char c : chars) {
                    int index = charDir.indexOf(String.valueOf(c));
                    value += 2<<index;
                }
                System.out.println(s +":"+ value);
                if (map.containsKey(value)){
                    map.get(value).add(s);
                }else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(value,list);
                }
            }

            if (MapUtils.isNotEmpty(map)) {
                Set<Map.Entry<Integer, List<String>>> entrySet = map.entrySet();
                for (Map.Entry<Integer, List<String>> entry : entrySet) {
                    System.out.println(entry.getValue());
                }
            }
        }
    }

    public int String2Int(String s){
        String charDir="abcdefghijklmnopqrstuvwxyz";
        String lowerCase = s.toLowerCase();
        char[] chars = lowerCase.toCharArray();
        Integer value = 0;
        for (char c : chars) {
            int index = charDir.indexOf(String.valueOf(c));
            value += 2<<index;
        }
        System.out.println(s +":"+ value);
        return value;
    }
}
