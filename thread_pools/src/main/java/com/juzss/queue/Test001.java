package com.juzss.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Test001 {
     // 队列遵循先进先出,后进后出的原则
	// 阻塞式队列最大好处, 能够防止队列容器溢出,防止丢失数据
	public static void main(String[] args) {
		//非阻塞队列,无界  使用无界队列时候
		ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
		concurrentLinkedQueue.offer("张三");
		concurrentLinkedQueue.offer("李四");
		concurrentLinkedQueue.offer("王五");
		// 获取队列 只能获取一个队列元素
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		System.out.println(concurrentLinkedQueue.poll());
		// 获取队列个数
		System.out.println(concurrentLinkedQueue.size());
	}
}
