package com.relyy.algorithm.List;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 检查字符串中的括号是否符合规范
 * right （），{[]}，[()]
 * wrong [{(}])
 * @author cairuirui
 * @create 2019/3/27
 */
public class CheckBrackets {

    public static void main(String[] args) {
        String s = "(()(([{}]))()){}";
        System.out.println(check(s));
    }

    public static boolean check(String s){
        Map<String, String> map = new HashMap<>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");
        String brackets = "(){}[]";
        Stack<String> bracketStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            String bracket = String.valueOf(c);
            if (!brackets.contains(bracket)) continue;
            if (map.containsKey(bracket)) {
                if (!bracketStack.peek().equals(map.get(bracket))) {
                    return false;
                }
                bracketStack.pop();
            }else {
                bracketStack.push(bracket);
            }
        }
        return bracketStack.empty();
    }
}
