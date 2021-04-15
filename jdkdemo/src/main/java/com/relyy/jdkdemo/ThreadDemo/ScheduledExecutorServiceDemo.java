package com.relyy.jdkdemo.ThreadDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/4/1
 */
public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread_name" + Thread.currentThread().getName());
			}
		},5,5, TimeUnit.SECONDS);

	}
}
