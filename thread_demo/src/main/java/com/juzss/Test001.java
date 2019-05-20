package com.juzss;

//1. 继承thread类,重写run方法,run方法中,需要线程执行代码
class ThreadDemo1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("main..子线程正在执行"+i);
		}
	}
}
//1.什么是线程 线程是一条执行路径,每个线程互不影响
//2.什么是多线程 多线程是一个进程中,有多条执行路径,并行执行。目的为了提高程序效率。
//3.在一个进程中,一定会有主线程
public class Test001 {
	
	//交替执行
	public static void main(String[] args) {
		//线程几种分类 用户线程、守护线程
		//主线程 子线程 GC线程
		
		System.out.println("主线程正在开始运行");
		
		//创建线程
		ThreadDemo1 threadDemo1 = new ThreadDemo1();
		//开启线程
	    threadDemo1.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("线程正在运行中"+i);
		}
		System.out.println("主线程正在结束运行");
	}

}
