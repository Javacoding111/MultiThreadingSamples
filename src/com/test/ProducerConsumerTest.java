package com.test;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {
	
	public static void main(String[] args) {
		
		Queue<Integer> list = new LinkedList<>();
		Producer producer = new Producer(list);
		Consumer consumer = new Consumer(list);
		
		Thread producerThread = new Thread(producer);
		Thread consumerthread = new Thread(consumer);
		
		producerThread.start();
		consumerthread.start();
	}

}
