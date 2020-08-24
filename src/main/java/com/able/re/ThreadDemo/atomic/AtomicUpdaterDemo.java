package com.able.re.ThreadDemo.atomic;

import org.springframework.context.annotation.ScopeMetadataResolver;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/8/21
 */
public class AtomicUpdaterDemo implements Runnable {

	static Score math;
	static Score computer;

	public static AtomicIntegerFieldUpdater<Score> scoreAtomicUpdater
			= AtomicIntegerFieldUpdater.newUpdater(Score.class,"score");
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			computer.score++;
			scoreAtomicUpdater.getAndIncrement(math);
		}
	}

	public static class Score{
		volatile int score;
	}

	public static void main(String[] args) throws InterruptedException{
		math = new Score();
		computer = new Score();
		AtomicUpdaterDemo atomicUpdaterDemo = new AtomicUpdaterDemo();
		Thread thread1 = new Thread(atomicUpdaterDemo);
		Thread thread2 = new Thread(atomicUpdaterDemo);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("普通变量的结果："+ computer.score);
		System.out.println("升级后的结果：" + math.score);
	}
}
