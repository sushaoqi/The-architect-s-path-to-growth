package com.juzss.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Thread005 {
	  public static void main(String[] args) {
		  // 可缓存的线程池重复利用  无限大小
		  ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		  for (int i = 0; i < 10; i++) {
			  final int temp = i;
			  //可执行线程execute 方法表示启动线程
			   newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName()+ "," + temp);
				}
			});
		  }
	  }
}
