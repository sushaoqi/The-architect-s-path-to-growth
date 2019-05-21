package com.juzss;

import java.util.concurrent.atomic.AtomicInteger;

//两个线程, 同时操作一个全局变量, 显示线程安全问题。
public class Thread004 implements Runnable{
    
	
	// 共享的全局变量
	//private  int  count = 1;
	
	private AtomicInteger atomicInteger = new AtomicInteger(); //线程安全
	
	
	@Override
	public void run() {
		while (true) {
			Integer count = getCount();
			if(count >= 50) {
				break;
			}
			System.out.println(count);
		}
	}
   
	
    //synchronized可以保证重入性,原子性,可见性
	public  synchronized Integer getCount() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return count++;
		// 每次自增1
		return atomicInteger.incrementAndGet();
	}
	
	
	public static void main(String[] args) {
		Thread004 thread004 = new Thread004();
		Thread t1 = new Thread(thread004);
		Thread t2 = new Thread(thread004);
		t1.start();
		t2.start();
	}
}
