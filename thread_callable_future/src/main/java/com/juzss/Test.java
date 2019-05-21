package com.juzss;

public class Test extends Thread {
	
	
	@Override
	public void run() {
		// 特别多的代码...省略... 没有阻塞情况。
		// 阻塞的情况产生的原因:  请求、读数据库、循环IO操作 可能发生阻塞
		// http.post()---阻塞2秒
		// IO密集 :该任务需要大量的IO阻塞, 产生阻塞, 如果在单线程中执行阻塞,使用可以多线程技术。
		// CPU运算能力, 不会浪费等待资源。 多配置线程数 = 2*CPU核数 = 24
		
		// CPU密集:该任务的时候, 不会产生大量IO阻塞, CPU运行的时候特别快。配置线程数=CPU核数 12
		
	}

}
