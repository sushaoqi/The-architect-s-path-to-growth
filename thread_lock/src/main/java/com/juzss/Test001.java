package com.juzss;

import java.util.Set;

// 重入锁 轻量级(Lock)与重量级锁(Synchronized) --可重入性(递归锁)
public class Test001 implements Runnable{

	@Override
	public void run() {
		set();
	}
    
	// synchroinzed 是什么时候释放锁?
	public synchronized void set() {
		System.out.println("name:" + Thread.currentThread().getName()+"-get();");
		get();
	}
	
	public synchronized void get() {
		System.out.println("name:" + Thread.currentThread().getName()+"-synchronized 具备有重入性-get方法");
	}
	
	public static void main(String[] args) {
		Test001 test001 = new Test001();
		Thread t1 = new Thread(test001);
		t1.start();
	}
}
