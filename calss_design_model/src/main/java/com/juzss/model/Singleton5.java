package com.juzss.model;

// 双重锁实现单例
public class Singleton5 {
   
	//禁止重排序,保证可见性,原子性不能保证
	private  static volatile Singleton5 singleton5;
	
	private Singleton5() {}
	
	
	// 线程安全 效率低
	public static Singleton5 getInstance() {
		if(singleton5 == null) {
			synchronized (Singleton5.class) {
				singleton5 = new Singleton5();
			}
		}
		return singleton5;
	}
	
	public static void main(String[] args) {
		Singleton5 s1 =  Singleton5.getInstance();
		Singleton5 s2 =  Singleton5.getInstance();
		System.out.println(s1 == s2);
	}
}
