package com.test;

public class ArrayIncrementDecrement {
	
	static int[] array = {0};
	
	public static void main(String[] args) throws InterruptedException {
		ArrayIncrementDecrement incDec = new ArrayIncrementDecrement();
		Thread a = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					incDec.increment();
				}
			}
		};
		
		Thread b = new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					incDec.decrement();
				}
			}
		};
		a.start();
		b.start();
		a.join();
		b.join();
		System.out.println(array[0]);
	}
	
	public synchronized void increment() {
		array[0]++;
	}
	
	public synchronized void decrement() {
		array[0]--;
	}
	
			
}
