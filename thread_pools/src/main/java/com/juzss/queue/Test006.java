package com.juzss.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test006 {
	public static void main(String[] args) {
		// 可固定长度线程池 
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			  final int temp = i;
			  //可执行线程execute 方法表示启动线程
			  fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName()+ "," + temp);
				}
			});
		  }
	}
}
