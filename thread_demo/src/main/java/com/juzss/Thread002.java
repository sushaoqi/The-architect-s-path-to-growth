package com.juzss;

class  ThreadDemo02 implements  Runnable{
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("子线程正在执行"+i);
		}
	}
}

//创建多线程的第二种方式,实现Runnable接口,重写run方法
public class Thread002 {
   public static void main(String[] args) {
	   System.out.println("主线程开始执行....");
	   //创建线程
	   ThreadDemo02 threadDemo02 = new ThreadDemo02();
	   //开启线程
	   Thread thread = new Thread(threadDemo02);
	   thread.start();
	   for (int i = 0; i < 10; i++) {
		   System.out.println("主线程正在执行"+i);
	  }
	  System.out.println("主线程结束执行");
	   
   }
}
