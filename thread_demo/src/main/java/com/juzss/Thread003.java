package com.juzss;

//创建线程,使用匿名内部类
public class Thread003 {
	public static void main(String[] args) {
		System.out.println("main...主线程开始执行");
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("子线程" + i);
				}
			}
		});
		//开启线程
		t1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程正在运行中"+i);
		}
		System.out.println("main...主线程结束");
	}
}
