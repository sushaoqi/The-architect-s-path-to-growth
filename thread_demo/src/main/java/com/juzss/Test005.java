package com.juzss;

/**
 * 用户线程 是主线程创建的线程。 非守护线程
 * 守护线程 和主线程一起销毁
 * @author Shinelon
 *
 */
public class Test005 {
   public static void main(String[] args) {
	  System.out.println("主线程正在开始执行");
	  Thread thread = new Thread(new Runnable() {
		public void run() {
			for (int i = 0; i < 30; i++) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("子线程"+i);
			}
		}
	});
	  thread.setDaemon(true); //该线程为守护线程 和主线程一起销毁
	  thread.start();
	  for (int i = 0; i < 5; i++) {
		  try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("主线程正在执行"+i);
		
	  }
	  System.out.println("主线程正在结束");
	  
   }
}
