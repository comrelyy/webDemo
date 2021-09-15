package com.relyy.algorithm.graph;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 火星词典：
 * 给定已经按照词典排序的顺序的单：
 * [wef,wrt,wrf,er,ett,rftt]   输出字母顺序：wertf
 * [z,x,z] 输出“”
 */
public class AlienOrder {
    /**
     *  1 根据输入构建有向图
     *  2 dui有向图进行拓扑排序
     */

    public static String getOrderStr(String[] words){
        if (null == words && words.length == 0) {
            return null;
        }
        if (words.length == 1){
            return words[0];
        }

        //构建有向图：邻接链表
        Map<Character, List<Character>> adjListMap = Maps.newHashMap();

        /**
         * 两两比较字符串
         * 对每一个出现的字母都创建一个图里的顶点
         * 一旦发现两个字母不同就邻接这两个顶点
         */

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i],w2 = words[i + 1];
            int n1 = w1.length(),n2 = w2.length();

            //w1,w2中出现不同字母时，只需处理好这两个字母，或顶点之间的关系
            //剩余字母就不用考虑了
            boolean found = false;

            for (int j = 0; j < Math.max(n1, n2); j++) {
                Character c1 = j < n1 ? w1.charAt(j) : null;
                Character c2 = j < n2 ? w2.charAt(j) : null;
                if (c1 != null && !adjListMap.containsKey(c1)){
                    adjListMap.put(c1, Lists.newArrayList());
                }
                if (c2 != null && !adjListMap.containsKey(c2)){
                    adjListMap.put(c2, Lists.newArrayList());
                }

                if (c1 != null && c2 != null && c1 != c2 && !found){
                    adjListMap.get(c1).add(c2);
                    found = true;
                }

                if(found){
                    continue;
                }
            }
        }

        /**
         * 需要进行拓扑排序
         */
        Set<Character> visited = Sets.newHashSet();
        Set<Character> loop = Sets.newHashSet();
        //记录邻接链表的顶点顺序，倒序之后就是要求的字符串
        Stack<Character> stack = new Stack<>();

        for (Character key : adjListMap.keySet()) {
            if(!visited.contains(key)) {
                topoLogicalSort(adjListMap, key, visited, loop, stack);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();

    }

    /**
     * 拓扑排序 深度优先
     * @param adjListMap 有向图
     * @param key
     * @param visited 记录已经访问过的顶点
     * @param loop 防止有向图中出现环的情况
     * @param stack 入栈元素必须是已经将和其有关系的顶点都处理完毕了
     * @return
     */
    private static boolean topoLogicalSort(Map<Character, List<Character>> adjListMap, Character key, Set<Character> visited,
                                        Set<Character> loop, Stack<Character> stack) {
        visited.add(key);
        loop.add(key);

        if(adjListMap.containsKey(key)){
            for (int i = 0; i < adjListMap.get(key).size(); i++) {
                Character character = adjListMap.get(key).get(i);

                if (loop.contains(character)) {
                    return false;
                }

                if (!visited.contains(character)) {
                    if (!topoLogicalSort(adjListMap, character, visited, loop, stack)) {
                        return false;
                    }
                }
            }
        }

        loop.remove(key);
        stack.push(key);
        return true;
    }

    public static void main(String[] args) {
       String[] words = {"wef","wrt","wrf","er","ett","rftt"};
        String orderStr = getOrderStr(words);
        System.out.println(orderStr);
    }
}
