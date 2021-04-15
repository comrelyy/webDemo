package com.relyy.jdkdemo.ThreadDemo.ThreadPool;

import com.relyy.jdkdemo.ThreadDemo.MyThread2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/19
 */
public class TreadPoolServiceDemo {

	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
		int i = 15;
		for (int i1 = 0; i1 < i; i1++) {
			threadPoolExecutor.execute(new MyThread2());
		}

	}
}
