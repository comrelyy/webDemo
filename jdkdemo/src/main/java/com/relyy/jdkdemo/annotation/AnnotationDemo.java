package com.relyy.jdkdemo.annotation;

import com.relyy.jdkdemo.clone.ShallowClone.StudentVO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description
 * @Created by Reeve Cai
 * @Date 2022/2/9
 */
public class AnnotationDemo {

	public static void main(String[] args) {
		Class<Student> studentClass = Student.class;
		Component annotation = studentClass.getAnnotation(Component.class);
		Annotation[] annotations = studentClass.getAnnotations();
		Method[] declaredMethods = studentClass.getDeclaredMethods();
		Class<? extends Annotation> aClass = annotation.annotationType();
		String name = aClass.getName();
		System.out.println(name);
	}
}
