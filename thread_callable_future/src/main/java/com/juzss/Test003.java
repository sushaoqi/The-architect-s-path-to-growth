package com.juzss;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test003 {
   
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		Future<String> submit = newCachedThreadPool.submit(new TaskCallable());
		System.out.println("1.主线程正在运行");
		//获取执行结果
		String result = submit.get();
		
		System.out.println("2.result:" + result);
		// Future模式
	}
	
}
class TaskCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("3.正在执行任务,需要等待五秒时间,执行任务开始");
		Thread.sleep(5000);
		System.out.println("4.正在执行任务,需要等待五秒时间,执行任务结束");
		return "小马";
	}
	
}