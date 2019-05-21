package com.juzss;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 演示lock锁是否具备可重入性  特征: 锁可以传递(方法递归传递)   synchonized重量级锁底层实现原理
public class Test002  extends Thread{
	
	Lock lock = new ReentrantLock();
	
	
	@Override
	public void run() {
		set();
	}
    
	// synchroinzed 是什么时候释放锁?
	public synchronized void set() {
		try {
			lock.lock();
			System.out.println("name:" + Thread.currentThread().getName()+"-get();");
			get();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public synchronized void get() {
		try {
			lock.lock();
			System.out.println("name:" + Thread.currentThread().getName()+"-lock 具备有重入性-get方法");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Test002 test002 = new Test002();
		Thread t2 = new Thread(test002);
		t2.start();
	}
	
	

}
