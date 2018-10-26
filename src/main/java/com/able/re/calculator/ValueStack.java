package com.able.re.calculator;

import java.util.LinkedList;

/**
 * 使用LinkedList来模拟实现栈
 *
 * @author cairuirui
 * @create 2018/10/23
 */
public class ValueStack<E> {

    private LinkedList list;

    public ValueStack(){
        list = new LinkedList<E>();
    }

    public void push(E e){
        list.addFirst(e);
    }

    public E pop(){
        return (E)list.removeFirst();
    }

    public int size(){
        return list.size();
    }
}
