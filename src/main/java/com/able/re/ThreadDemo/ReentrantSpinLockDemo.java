package com.able.re.ThreadDemo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 可重入的自旋锁
 * @Created by cairuirui
 * @Date 2020/8/20
 */
public class ReentrantSpinLockDemo {

	private AtomicReference<Thread> owner = new AtomicReference<>();

	private int count = 0;

	public void lock(){
		Thread t = Thread.currentThread();
		if (t == owner.get()) {
			++count;
			return;
		}
		while(!owner.compareAndSet(null,t)){
			System.out.println("自旋了");
		}
	}

	public void unlock(){
		Thread thread = Thread.currentThread();
		if (thread == owner.get()) {
			if (count > 0) {
				--count;
			}else {
				owner.set(null);
			}
		}
	}

	public static void main(String[] args) {
		ReentrantSpinLockDemo spinLock = new ReentrantSpinLockDemo();
		new Runnable(){

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
				spinLock.lock();
				try{
					System.out.println(Thread.currentThread().getName() + "获取到了自旋锁");
					Thread.sleep(4000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					spinLock.unlock();
					System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
				}
			}
		};
	}

}
