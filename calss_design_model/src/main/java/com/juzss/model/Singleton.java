package com.juzss.model;


//饿汉式
public class Singleton {
  
	
	// 类初始化的时候,就会创建对象,天生线程安全,调用效率比较高,如果在不使用对象的时候,会浪费内存。
	private static final Singleton singleton = new Singleton();
	//将构造函数私有化
	private Singleton() {}
	
	public static Singleton getSingleton() {
		return singleton;
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();
		System.out.println(s1==s2);
		
	}
}
