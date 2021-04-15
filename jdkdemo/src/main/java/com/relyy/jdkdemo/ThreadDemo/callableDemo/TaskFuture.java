package com.relyy.jdkdemo.ThreadDemo.callableDemo;

import java.util.Set;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/26
 */
public class TaskFuture implements Runnable {

	Integer productId;
	Set<Integer> prices;

	TaskFuture(Integer productId,Set<Integer> prices){
		this.productId = productId;
		this.prices = prices;
	}

	@Override
	public void run() {
		int price = 0;
		try{
			Thread.sleep((long)(Math.random() * 4000));
			price = (int)(Math.random() * 4000);
		} catch(Exception e){
		    e.getStackTrace();
		}
		prices.add(price);
	}
}
