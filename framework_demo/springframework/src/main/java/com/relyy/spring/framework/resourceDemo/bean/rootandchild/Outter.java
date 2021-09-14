package com.relyy.spring.framework.resourceDemo.bean.rootandchild;

import lombok.Data;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/5
 */
@Data
public class Outter {

	private String name;
	private Integer age;
	private InnerBean inner;
}
