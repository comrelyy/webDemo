package com.able.re.jdk8demo;

/**
 * $DISCRIPTION
 *
 * @author cairuirui
 * @create 2018-01-13
 */
@FunctionalInterface
public interface MyFunc<T>  {
    public T getValue(T t);
}
