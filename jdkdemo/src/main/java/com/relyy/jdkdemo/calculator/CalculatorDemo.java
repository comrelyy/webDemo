package com.relyy.jdkdemo.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018/10/23
 */
public class CalculatorDemo {

    public static String calculator(String s){
        String value ="NaN";
        if (StringUtils.isNotEmpty(s)) {
            ValueStack<String> numStack = new ValueStack<>();
            ValueStack<String> symbolStack = new ValueStack<>();
            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char aChar : chars) {
                if ( '0'<= aChar && aChar <= '9'){
                    sb.append(aChar);
                }else {
                    String num = sb.toString();
                    sb.setLength(0);
                    numStack.push(num);
                    String symbol = "";
                    if (aChar != '=') {
                        String symbol2 = String.valueOf(aChar);
                        if (symbolStack.size() > 0){
                            symbol = symbolStack.pop();
                            if ("+,-".contains(symbol) && "*,/".contains(symbol2)){
                                symbolStack.push(symbol);
                            }else {
                                String num1 = numStack.pop();
                                String num2 = numStack.pop();
                                value = getCalculateResult(symbol, num1, num2);
                                numStack.push(value);
                                if ("*,/".contains(symbol) && "+,-".contains(symbol2)){
                                    while (symbolStack.size() > 0){
                                        value = getCalculateResult(symbolStack.pop(), numStack.pop(), numStack.pop());
                                        numStack.push(value);
                                    }
                                }
                            }
                        }
                        symbolStack.push(symbol2);
                    }else {
                        while (symbolStack.size() > 0){
                            value = getCalculateResult(symbolStack.pop(), numStack.pop(), numStack.pop());
                            numStack.push(value);
                        }
                        value = numStack.pop();
                    }

                }
            }
        }

        return value;
    }

    public static String getCalculateResult(String symbol, String num1, String num2) {
        Integer var = null;
        switch (symbol){
            case "+" : var = Integer.valueOf(num2) + Integer.valueOf(num1);break;
            case "-" : var = Integer.valueOf(num2) - Integer.valueOf(num1);break;
            case "*" : var = Integer.valueOf(num2) * Integer.valueOf(num1);break;
            case "/" : var = Integer.valueOf(num2) / Integer.valueOf(num1);break;
            default:break;
        }

        if (null != var) {
           return String.valueOf(var);
        }
        return null;
    }

    public static void main(String[] args) {
        while (true){
            System.out.println("请输入四则混合计算式：");
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            System.out.println(s+calculator(s));
        }
    }
}
