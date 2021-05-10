package com.relyy.jdkdemo.ThreadDemo.lockDemo.multiLock;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/5/6
 */
public interface ILock extends Comparable<ILock> {

	long DEFAULT_DELAY = 1000L;

	/**
	 *获取锁key,锁的唯一标识
	 * @return
	 */
	String getKey();


	void rUnLock();

	void wUnLock();

	/**
	 *
	 */
	void rLock();

	void wLock();

	boolean tryRLock(long ts, TimeUnit timeUnit);

	boolean tryWLock(long ts, TimeUnit timeUnit);

	boolean isWHeldByCurrentThread();

	int getPriority();

}
