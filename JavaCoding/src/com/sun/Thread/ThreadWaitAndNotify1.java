package com.sun.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadWaitAndNotify1 {
	Bread bread=new Bread();
	Cosumer1 cosumer=new Cosumer1(bread);
	Product1 product=new Product1(bread);
	ExecutorService exec=Executors.newCachedThreadPool();
	public  ThreadWaitAndNotify1() throws InterruptedException
	{
		exec.execute(cosumer);
		exec.execute(product);
		TimeUnit.SECONDS.sleep(1);
		exec.shutdown();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new ThreadWaitAndNotify1();
	}

}

class Bread {
	public boolean canEat = false;

	public synchronized void waitForEat() {
		// TODO Auto-generated method stub
		canEat=true;
		notifyAll();
	}

	public synchronized void productBread() throws InterruptedException {
		// TODO Auto-generated method stub
		if(canEat)
		{
			wait();
		}
	}

	public synchronized void cosumeBread() throws InterruptedException {
		// TODO Auto-generated method stub
		if(!canEat)
		{
			wait();
		}
	}

	public synchronized void waitForProduct() {
		// TODO Auto-generated method stub
		canEat=false;
		notifyAll();
	}
}

class Product1 implements Runnable {
	public Bread bread;

	public Product1(Bread bread) {
		this.bread = bread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted())
		{
				try {
					bread.productBread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("product bread");
				bread.waitForEat();
		}
	}

}

class Cosumer1 implements Runnable{
	public Bread bread;

	public Cosumer1(Bread bread) {
		this.bread = bread;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted())
		{
				try {
					bread.cosumeBread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("cosumer bread");
				bread.waitForProduct();
		}
	}
}