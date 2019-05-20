package com.juzss.thread01;

public class ThreadTrain implements Runnable {
	private int trainCount = 100;

	@Override
	public void run() {
		while (trainCount > 0) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {

			}
			sale();
		}
	}

	public void sale() {
		synchronized (this) {
			if (trainCount > 0) {
				System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - trainCount + 1) + "张票");
				trainCount--;
			}
		}

	}

	public static void main(String[] args) {
		ThreadTrain threadTrain = new ThreadTrain();
		Thread t1 = new Thread(threadTrain, "①号");
		Thread t2 = new Thread(threadTrain, "②号");
		t1.start();
		t2.start();
	}

}
