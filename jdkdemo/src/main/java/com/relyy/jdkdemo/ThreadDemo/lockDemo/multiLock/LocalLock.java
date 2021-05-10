package com.relyy.jdkdemo.ThreadDemo.lockDemo.multiLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2021/5/6
 */
public class LocalLock extends ReentrantReadWriteLock implements ILock {
	private static final int DEFAULT_PRI = 0;

	private String key;
	private int priority;

	private volatile String wHolder;

	public String getwHolder() {
		return wHolder;
	}

	public LocalLock(String key) {
		this.key = key;
		this.priority = DEFAULT_PRI;
	}

	public LocalLock(String key, int priority) {
		this.key = key;
		this.priority = priority;
	}

	public LocalLock(boolean fair, String key, int priority) {
		super(fair);
		this.key = key;
		this.priority = priority;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public void rUnLock() {
		this.readLock().unlock();
	}

	@Override
	public void wUnLock() {
		this.writeLock().unlock();
	}

	@Override
	public void rLock() {
		this.readLock().lock();
	}

	@Override
	public void wLock() {
		this.writeLock().lock();
		this.wHolder = Thread.currentThread().getName();
	}

	@Override
	public boolean tryRLock(long ts, TimeUnit timeUnit) {
		try{
			return this.readLock().tryLock(ts, timeUnit);
		}catch(Exception e){
			// todo log记录
			return false;
		}
	}

	@Override
	public boolean tryWLock(long ts, TimeUnit timeUnit) {
		try{
			boolean ret = this.writeLock().tryLock(ts, timeUnit);
			this.wHolder = Thread.currentThread().getName();
			return ret;
		}catch(Exception e){
			// todo log记录
			return false;
		}
	}

	@Override
	public boolean isWHeldByCurrentThread() {
		return this.writeLock().isHeldByCurrentThread();
	}

	@Override
	public int getPriority() {
		return this.priority;
	}

	@Override
	public int compareTo(ILock o) {
		int x = this.priority;
		int y = o.getPriority();
		if (x == y){
			x = this.key.hashCode();
			y = o.getKey().hashCode();
		}
		return Integer.compare(x,y);
	}
}
