package com.relyy.spring.framework.resourceDemo.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/4/28
 */
@Configurable
public class StudentFactoryBean implements FactoryBean<Student> {

	private String studentInfo;

	@Override
	public Student getObject() throws Exception {
		if (this.studentInfo == null) {
			throw new IllegalArgumentException("studentInfo is required");
		}

		String[] split = studentInfo.split(",");
		if (null == split || split.length != 3){
			throw new IllegalArgumentException("studentInfo config error");
		}

		Student student = new Student(split[0], Integer.valueOf(split[1]), split[2]);
		return student;
	}

	@Override
	public Class<?> getObjectType() {
		return StudentFactoryBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setStudentInfo(String studentInfo){
		this.studentInfo = studentInfo;
	}
}
