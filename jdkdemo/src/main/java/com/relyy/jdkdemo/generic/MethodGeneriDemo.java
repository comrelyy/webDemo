package com.relyy.jdkdemo.generic;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/8/23
 */
public class MethodGeneriDemo {

	public <T1,T2 extends Integer,T3 extends GenericT1 & GenericT2> T3 mehtod1(T1 t1,T2 t2,T3 t3,String s){
		return t3;
	}
	public static void main(String[] args) {
		//当前类中定义的所有方法，与修饰符无关
		Method[] declaredMethods = MethodGeneriDemo.class.getDeclaredMethods();
		Optional<Method> optionalMethod = Arrays.stream(declaredMethods)
				.filter(method -> method.getName().equals("mehtod1"))
				.findFirst();
		if (optionalMethod.isPresent()) {
			Method method = optionalMethod.get();
			System.out.println("mehtod1 方法参数列表信息：");
			Type[] genericParameterTypes = method.getGenericParameterTypes();
			Arrays.stream(genericParameterTypes).forEach(type -> {
				// TypeVariable表示泛型类型
				if (type instanceof TypeVariable){
					TypeVariable tv = (TypeVariable)type;
					System.out.println("变量类型名称："+tv.getTypeName());
					System.out.println("变量名称："+tv.getName());
					System.out.println("变量声明位置："+tv.getGenericDeclaration());
					Type[] bounds = tv.getBounds();
					System.out.println("变量的上边界数量："+ bounds.length + ",上边界清单为:");
					Arrays.stream(bounds).forEach(bound -> System.out.println(bound.getTypeName()));
				}else if (type instanceof Class){
					Class clazz = (Class) type;
					System.out.println("变量类型名称："+clazz.getTypeName());
					System.out.println("变量名称："+clazz.getName());
				}
				System.out.println("-------------------");
			});

			//获取方法的返回值
			System.out.println("方法返回值信息......");
			Type genericReturnType = method.getGenericReturnType();
			if (genericReturnType instanceof TypeVariable){
				TypeVariable pt = (TypeVariable) genericReturnType;
				System.out.println("变量名称:" + pt.getName());
				System.out.println("这个变量在哪声明的:" + pt.getGenericDeclaration());
				Type[] bounds = pt.getBounds();
				System.out.println("这个变量上边界数量:" + bounds.length);
				System.out.println("这个变量上边界清单:");
				for (Type bound : bounds) {
					System.out.println(bound.getTypeName());
				}
				System.out.println("--------------------");
			}

			//获取方法中申请的泛型参数列表
			TypeVariable<Method>[] typeParameters = method.getTypeParameters();
			for (TypeVariable<Method> pt : typeParameters) {
				System.out.println("变量类型名称:" + pt.getTypeName());
				System.out.println("变量名称:" + pt.getName());
				System.out.println("这个变量在哪声明的:" + pt.getGenericDeclaration());
				Type[] bounds = pt.getBounds();
				System.out.println("这个变量上边界数量:" + bounds.length);
				System.out.println("这个变量上边界清单:");
				for (Type bound : bounds) {
					System.out.println(bound.getTypeName());
				}
				System.out.println("--------------------");
			}
		}

	}
}
