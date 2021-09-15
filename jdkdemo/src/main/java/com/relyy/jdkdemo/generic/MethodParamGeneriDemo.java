package com.relyy.jdkdemo.generic;

import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/8/23
 */
public class MethodParamGeneriDemo<T>{

	public class C1<T> {
		public List<T> innerMethod(List<T> t){
			return t;
		}
	}

	/**
	 * 泛型变量 TypeVariable 表示<>中的内容
	 * @param t
	 * @return
	 */
	public List<C1<T>> method1(C1<T> t){
		return Lists.newArrayList();
	}

	/**
	 * ? extends Number 可接受的类型是Number及其子类，定义泛型的上边界Number
	 * ? super C2 可接受元素是C2以及其父类，定义泛型的下边界 C2
	 * 通配符的泛型类型 WildcardType
	 * @param t
	 * @return
	 */
	public Set<? extends Number> method2(Set<? extends Number> t){
		return t;
	}

	/**
	 * 泛型数组 GenericArrayType
	 * @param genericArray
	 * @return
	 */
	public T[] method3(T[] genericArray){
		return genericArray;
	}

	public static void main(String[] args) throws Exception{
		Method method1 = MethodParamGeneriDemo.class.getMethod("method1", MethodParamGeneriDemo.C1.class);
		Type genericParameterType = method1.getGenericParameterTypes()[0];
		if (genericParameterType instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) genericParameterType;
			System.out.println(parameterizedType.getRawType());//原始类型  <>前的类型
			System.out.println(parameterizedType.getOwnerType());//所属类型 变量所在的类型
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			Type actualTypeArgument = actualTypeArguments[0];
			System.out.println(actualTypeArgument.getClass());
		}

		Method innerMethod = MethodParamGeneriDemo.C1.class.getMethod("innerMethod", List.class);
		Type innercals = innerMethod.getGenericParameterTypes()[0];
		if (innercals instanceof ParameterizedType){
			ParameterizedType parameterizedType = (ParameterizedType) innercals;
			System.out.println(parameterizedType.getRawType());//原始类型  <>前的类型
			System.out.println(parameterizedType.getOwnerType());//所属类型 <>里面的类型
			Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
			Type actualTypeArgument = actualTypeArguments[0];
			System.out.println(actualTypeArgument.getClass());
		}
	}
}
