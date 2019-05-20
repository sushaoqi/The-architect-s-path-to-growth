package com.juzss;

public class Thread006 {
   public static void main(String[] args) {
	 Thread thread = new Thread(new Runnable() {
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("子线程,i"+i);
			}
		}
	});
	 thread.start();
	 // 主线程让子线程执行完毕的话,应该怎么做?
	 try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 for (int i = 0; i < 20; i++) {
			System.out.println("主线程,i"+i);
	 }
   }
}
