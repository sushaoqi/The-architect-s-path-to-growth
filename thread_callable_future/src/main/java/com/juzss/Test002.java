package com.juzss;

public class Test002  extends Thread{
   
	// 执行下载请求(大概耗时10分钟)
	@Override
	public void run() {
	     // 下载请求.......
	}
	
	public static void main(String[] args) {
		Test002 test002 = new Test002();
		test002.start();
		// 主线程如何知道子线程程序执行完毕
	}
}
