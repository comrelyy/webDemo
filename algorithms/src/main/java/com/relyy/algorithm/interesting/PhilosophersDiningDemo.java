package com.relyy.algorithm.interesting;

/**
 * @Description 哲学家就餐问题
 * @Created by cairuirui
 * @Date 2020/9/1
 */
public class PhilosophersDiningDemo {

	public static class Philosopher implements Runnable {

		private Object leftChopstick;
		private Object rightChopstick;

		public Philosopher(Object leftChopstick,Object rightChopstick){
			this.leftChopstick = leftChopstick;
			this.rightChopstick = rightChopstick;
		}

		@Override
		public void run() {
			try{
				while (true){
					doAction("think everything");
					synchronized (leftChopstick){
						doAction("take leftChopstick");
						synchronized (rightChopstick){
							doAction("take rightChopstick");
							doAction("eating");
							doAction("put down rightChopstick");
						}
						doAction("put down leftChopstick");
					}
				}
			} catch(Exception e){
			    e.printStackTrace();
			}
		}

		private void doAction(String action) throws InterruptedException{
			System.out.println(Thread.currentThread().getName() + " " + action);
			Thread.sleep((long)(Math.random() * 10));
		}
	}

	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[5];
		Object[] chopsticks = new Object[philosophers.length];
		for (int i = 0; i < chopsticks.length; i++) {
			chopsticks[i] = new Object();
		}

		/**
		 * 模拟哲学家拿筷子吃饭，当五位哲学家没人都拿到筷子的时候会引起死锁
		 * 解决死锁问题：
		 *  1 引入服务员检查：哲学家吃饭前询问条件是否满足（规避死锁）
		 *  2 引入领导调节： 发生死锁后，可以进行资源剥夺（死锁后恢复）
		 *  3 改变哲学家拿锁的顺序： 其中一个哲学家与另外四位拿锁的顺序不一样（规避死锁）
		 */
		for (int i = 0; i < philosophers.length; i++) {
			Object leftChopstick = chopsticks[i];
			Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];
			philosophers[i] = new Philosopher(rightChopstick,leftChopstick);
			new Thread(philosophers[i],"哲学家"+ (i + 1) + "号").start();
		}
	}
}