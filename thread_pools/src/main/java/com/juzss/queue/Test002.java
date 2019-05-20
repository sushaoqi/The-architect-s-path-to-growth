package com.juzss.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test002 {
   // 如果存队列的时候, 如果满了,  就会等待, 如果取队列的时候,如果获取不到, 也会等待
	public static void main(String[] args) throws InterruptedException {
		// 最多支持3队列总数 阻塞式队列
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		// 最多支持3队列总数 阻塞式队列
		blockingQueue.offer("张三"); //添加非阻塞队列
		Boolean b1 = blockingQueue.offer("李四",3,TimeUnit.SECONDS); //添加阻塞队列
		System.out.println("b1:"+b1);
		blockingQueue.offer("王五");
		Boolean b2 = blockingQueue.offer("李四",3,TimeUnit.SECONDS); //添加阻塞队列
		System.out.println("b2:"+b2);
		
		
		
		
		
		/*
		 * System.out.println(blockingQueue.poll()); //不会等待
		 * System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
		 * //队列已经满了2个了,获取不到第三个,所以就等待了
		 * System.out.println(blockingQueue.poll(3,TimeUnit.SECONDS));
		 */
	}
}
