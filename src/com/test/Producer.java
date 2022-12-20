package com.test;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	
	private Queue<Integer> sharedQueue;
	
	public Producer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.size()==5) {
					try {
						System.out.println("Producer thread is waiting");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Random random = new Random();
				int data = random.nextInt();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedQueue.add(data);
				System.out.println("Produced data : " + data);
				sharedQueue.notify();
			}
		}
		
	}
	
	

}
