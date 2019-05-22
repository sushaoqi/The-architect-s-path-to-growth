package com.juzss.model;

//懒汉式  类初始化的,不会创建该对象,真正需要的时候才会加载(创建),天生线程不安全,需要解决线程安全问题,所以效率非常低。
public class Singleton2 {

	
	private static Singleton2 singleton2;
	
	private Singleton2() {}
    
	//线程安全 效率低 synchronized只保证一个线程去访问对象
	public static  synchronized Singleton2 getInstance() {
		if(singleton2 == null) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
	
	public static void main(String[] args) {
		Singleton2 s1 = Singleton2.getInstance(); 
		Singleton2 s2 = Singleton2.getInstance(); 
		System.out.println(s1 == s2);
	}
}
