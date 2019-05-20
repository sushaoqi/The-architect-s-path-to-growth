package com.juzss.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//生产者 添加队列
class ProducerThread implements  Runnable{
	
	
	private BlockingQueue<String> blockingQueue;
	private AtomicInteger count = new AtomicInteger();
	//volatile作用:可见性,但不保证原子性,禁止重排序
	private volatile boolean FLAG = true;
	
	
	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "生产者开始启动....");
		try {
			while (FLAG) {
				String data = count.incrementAndGet() + "";
				boolean offer = blockingQueue.offer(data,2,TimeUnit.SECONDS);
				if(offer) {
					System.out.println("生产者存入队列成功! data:"+data);
				}else {
					System.out.println("生产者存入队列失败! data:"+data);
				}
				Thread.sleep(1000);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName() + "生产者启动结束....");
		}
	}
	
	
	public void  stop() {
		this.FLAG = false;
	}
	
}

//消费者队列 获取队列
class ConsumerThread implements Runnable{
	private BlockingQueue<String> blockingQueue;
	private volatile boolean FLAG = true;
	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
 
	
	@Override
	public void run() {
		System.out.println("消费者线程已经启动");
		try {
			while (FLAG) {
				String data = blockingQueue.poll(2,TimeUnit.SECONDS);
				if(data == null) {
					System.out.println("消费者超过2秒时间, 没有获取队列信息");
					FLAG = false;
					return ;
				}
				System.out.println("消费者获取到data:"+data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("消费者已经结束....");
		}
	}
	
}

public class Test004 {
   
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
		ProducerThread producerThread = new ProducerThread(blockingQueue);
		ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
		Thread p1 = new Thread(producerThread);
		Thread c1 = new Thread(consumerThread);
		p1.start();
		c1.start();
		//10秒后 停止线程..
		try {
			Thread.sleep(10*1000);
			producerThread.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
		//让生产者不要再去生产了
		producerThread.stop();
	}
	   
}
