package com.juzss;

//现… 在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
public class JoinThreadDemo02 {
   public static void main(String[] args) {
	 Thread t1 = new Thread(new Runnable() {
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("t1,i"+i);
			}
		}
	});
	 
	 Thread t2 = new Thread(new Runnable() {
		public void run() {
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < 30; i++) {
				System.out.println("t2,i"+i);
			}
		}
	});
	 Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < 40; i++) {
					System.out.println("t3,i"+i);
				}
			}
		});
	 t1.start();
	 t2.start();
	 t3.start();
   }
}
