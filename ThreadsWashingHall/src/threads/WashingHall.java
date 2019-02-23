package threads;

import utility.collection.*;

public class WashingHall {
	private QueueADT<Hall> avaliableHalls;
	
	public WashingHall(int numberOfWashingHalls) {
		avaliableHalls=new ArrayQueue(numberOfWashingHalls);
		for(int i=0;i<numberOfWashingHalls;i++)
			avaliableHalls.enqueue(new Hall(i));
	}
	public synchronized Hall enterForWashing() {
		while(avaliableHalls.isEmpty()) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for a free spot.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Hall hall=avaliableHalls.dequeue();
		System.out.println(Thread.currentThread().getName()+" is being washed in "+hall);
		notifyAll();
		return hall;
	}
	public synchronized void leaveWashing(Hall hall) {
		while(avaliableHalls.isFull()) {
			try {
				System.out.println(Thread.currentThread().getName()+" is trying to leave, but was not in the hall!!!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has left "+hall);
		notifyAll();
		avaliableHalls.enqueue(hall);
	}
	public synchronized void drive() {
		System.out.println(Thread.currentThread().getName()+" is driving.");
	}
}
