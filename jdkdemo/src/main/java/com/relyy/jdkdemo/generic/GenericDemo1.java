package com.relyy.jdkdemo.generic;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description 类中定义泛型变量
 * @Created by cairuirui
 * @Date 2021/8/23
 */
public class GenericDemo1 <T1,T2 extends Integer,T3 extends GenericT1 & GenericT2>{
	public static void main(String[] args) {
		//TypeVariable接口表示的是泛型变量，如List<T>中的T就是类型变量
		TypeVariable<Class<GenericDemo1>>[] typeParameters = GenericDemo1.class.getTypeParameters();
		Arrays.stream(typeParameters).forEach(tp -> {
			System.out.println("变量名称："+tp.getName());
			System.out.println("变量声明位置：" + tp.getGenericDeclaration());
			//获取泛型变量类型的上边界，默认为Object
			Type[] bounds = tp.getBounds();
			System.out.println("变量的上边界数量："+ bounds.length + ",上边界清单为:");
			Arrays.stream(bounds).forEach(bound -> System.out.println(bound.getTypeName()));
		});
	}
}
