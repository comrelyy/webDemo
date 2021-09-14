package com.relyy.spring.framework.resourceDemo.bean.LookAndReplace;

import lombok.Data;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/6/8
 */
@Data
public abstract class Car {
	private Taxi taxi;

	//用于lookup-method
	public abstract Taxi createTaxi();
}
