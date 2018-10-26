package com.able.re.calculator;

/**
 * 运算基础 加、减、乘、除
 *
 * @author cairuirui
 * @create 2018/10/23
 */
public class Operator {

    private static Operator operator = new Operator();
    private Operator getOperator(){
        return operator;
    }

    public static Integer plus(int a,int b){
        return a + b;
    }

    public static Integer minus(int a, int b){
        return a - b;
    }

    public static Integer multiply(int a,int b){
        return a * b;
    }

    public static Integer divide(int a,int b){
        return a / b;
    }
}
