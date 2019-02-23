package Threads;

import utility.collection.*;

public class ToiletBuilding implements PublicToilet{
	private QueueADT<Person> cabinQ;
	private QueueADT<Person> sinkQ;
	private QueueADT<Person> dryerQ;
	private int noOfcabins;
	private int noOfsinks;
	private int noOfdryers;
	
	public ToiletBuilding(int noOfcabins, int noOfsinks, int noOfdryers) {
		this.noOfcabins=noOfcabins;
		this.noOfdryers=noOfdryers;
		this.noOfsinks=noOfsinks;
		cabinQ=new ArrayQueue<>();
		sinkQ=new ArrayQueue<>();
		dryerQ=new ArrayQueue<>();
	}
	public synchronized void stepIntoCabin(Person person) {
		System.out.println(Thread.currentThread().getName()+" entered the bathroom.");
		cabinQ.enqueue(person);
		while(noOfcabins<1) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for a cabin.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+" entered a cabin.");
			cabinQ.dequeue();
			noOfcabins--;
			notifyAll();
		
	}
	public synchronized void leaveCabin() {
		System.out.println(Thread.currentThread().getName()+" left a cabin.");
		noOfcabins++;
		notifyAll();
	}
	public synchronized void startWashingHands(Person person) {
		sinkQ.enqueue(person);
		while(noOfsinks<1) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for a sink.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+" is washing hands.");
			sinkQ.dequeue();
			noOfsinks--;
			notifyAll();
	}
	public synchronized void stopWashingHands() {
		System.out.println(Thread.currentThread().getName()+" has clean hands.");
		noOfsinks++;
		notifyAll();
	}
	public synchronized void startDryingHands(Person person) {
		dryerQ.enqueue(person);
		while(noOfdryers<1) {
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting for a dryer.");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(Thread.currentThread().getName()+" is drying hands.");
			dryerQ.dequeue();
			noOfdryers--;
			notifyAll();
	}
	public synchronized void stopDryingHands() {
		System.out.println(Thread.currentThread().getName()+" has dry hands.");
		noOfdryers++;
		notifyAll();
	}
	public synchronized void drinkLambrusco() {
		if(Thread.currentThread().getName().equals("Gosia"))
			System.out.println(Thread.currentThread().getName()+" is drinking coke");
		else
			System.out.println(Thread.currentThread().getName()+" is drinking Lambrusco");
	}
}
