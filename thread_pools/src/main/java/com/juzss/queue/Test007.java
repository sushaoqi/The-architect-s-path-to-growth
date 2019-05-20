package com.juzss.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test007 {
  public static void main(String[] args) {
	  //定时线程池
	  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
	  for (int i = 0; i < 10; i++) {
		  final int temp = i;
		  //定时线程schedule 方法表示调度线程
		  scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName()+ "," + temp);
			}
		}, 3, TimeUnit.SECONDS);
	  }
  }
}
