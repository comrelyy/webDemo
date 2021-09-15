package com.relyy.spring.framework.resourceDemo.bean.LookAndReplace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/8
 */
public class ReplaceDog implements MethodReplacer {
	@Override
	public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
		System.out.println("Hello I am a white dog...");
		Arrays.stream(objects).forEach(str -> System.out.println("参数: "+ str));
		return o;
	}
}
