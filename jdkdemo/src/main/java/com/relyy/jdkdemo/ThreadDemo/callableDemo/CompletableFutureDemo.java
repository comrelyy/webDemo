package com.relyy.jdkdemo.ThreadDemo.callableDemo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/26
 */
public class CompletableFutureDemo {
	private final CompletableFuture<Void> completableFuture = new CompletableFuture<Void>();

	public static void main(String[] args) {
		CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
		System.out.println(completableFutureDemo.getPrice());
	}

	private Set<Integer> getPrice(){
		Set<Integer> prices = Collections.synchronizedSet(new HashSet<Integer>());
		CompletableFuture<Void> task1 = CompletableFuture.runAsync(new TaskFuture(123, prices));
		CompletableFuture<Void> task2 = CompletableFuture.runAsync(new TaskFuture(456, prices));
		CompletableFuture<Void> task3 = CompletableFuture.runAsync(new TaskFuture(789, prices));

		CompletableFuture<Void> allOf = CompletableFuture.allOf(task1, task2, task3);

		try{
			allOf.get(3, TimeUnit.SECONDS);
		} catch(Exception e){

		}

		return prices;
	}
}
