package com.test;

import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Integer> sharedQueue;
	
	public Consumer(Queue<Integer> sharedQueue) {
		this.sharedQueue=sharedQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.isEmpty()) {
					try {
						System.out.println("Consumer thread is waiting ");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				int data = sharedQueue.remove();
				System.out.println("Consumed data : " + data);
				sharedQueue.notify();
			}
		}
		
	}

}
