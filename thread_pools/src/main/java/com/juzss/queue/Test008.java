package com.juzss.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test008 {
	public static void main(String[] args) {
		// 单化线程池
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int temp = i;
			// 可执行线程execute 方法表示启动线程
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + temp);
				}
			});
		}
		//  单化线程池红灯(要停掉)
		singleThreadExecutor.shutdown();
	}
}
