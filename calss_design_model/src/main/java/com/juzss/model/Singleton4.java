package com.juzss.model;

//使用枚举实现单例模式 优点:实现简单、枚举本身就是单例，由jvm从根本上提供保障!避免通过反射和反序列化的漏洞 缺点没有延迟加载。
public class Singleton4 {
	public static Singleton4 getInstance() {
		return SingletonDemo04.INSTANCE.getInstance();
	}

	private static enum SingletonDemo04 {
		INSTANCE;
		// 枚举元素为单例
		private Singleton4 Singleton4;

		private SingletonDemo04() {
			System.out.println("SingletonDemo04");
			Singleton4 = new Singleton4();
		}

		public Singleton4 getInstance() {
			return Singleton4;
		}
	}

	public static void main(String[] args) {
		Singleton4 u1 = Singleton4.getInstance();
		Singleton4 u2 = Singleton4.getInstance();
		System.out.println(u1 == u2);
	}
}