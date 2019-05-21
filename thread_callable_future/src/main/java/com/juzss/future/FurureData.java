package com.juzss.future;

// FutureData,当有线程想要获取RealData的时候,程序会被阻塞。等到RealData被注入才会使用getReal()方法
public class FurureData implements Data {
	
	
	public volatile static boolean FLAG = false;
	private RealData realData;

	public synchronized void setRealData(RealData realData) {
		// 如果已经获取到结果，直接返回
		if (FLAG) {
			return;
		}
		// 如果没有获取到数据,传递真是对象
		this.realData = realData;
		FLAG = true;
		// 进行通知
		notify();
	}

	@Override
	public synchronized String getRequest() {
		while (!FLAG) {
			try {
				wait();
			} catch (Exception e) {

			}
		}
		// 获取到数据,直接返回
		return realData.getRequest();
	}
}
