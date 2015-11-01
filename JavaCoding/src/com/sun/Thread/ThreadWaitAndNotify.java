package com.sun.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadWaitAndNotify {
	Goods goods=new Goods(1);
	public Product product=new Product(goods,this);
	public Cosumer cosumer=new Cosumer(goods,this);
	ExecutorService exec=Executors.newCachedThreadPool();
	public ThreadWaitAndNotify() throws Exception
	{
		exec.execute(product);
		exec.execute(cosumer);
		TimeUnit.SECONDS.sleep(1);
		exec.shutdown();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new ThreadWaitAndNotify();
		
	}

}
class Goods{
	private int id;
	public boolean hasProduct = false;
	public Goods(int id)
	{
		this.id = id;
	}
}
class Product implements Runnable{
	Goods goods;
	ThreadWaitAndNotify t;
	public Product(Goods goods,ThreadWaitAndNotify t) {
		// TODO Auto-generated constructor stub
		this.goods=goods;
		this.t=t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted())
		{
			try {
				synchronized (this) {
					if(goods.hasProduct)
					{
						wait();
					}
				}
				System.out.println("product goods");
				synchronized (this.t.cosumer) {
					goods.hasProduct=true;
					t.cosumer.notifyAll();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
}
class Cosumer implements Runnable{
	Goods goods;
	ThreadWaitAndNotify t;

	public Cosumer(Goods goods,	ThreadWaitAndNotify t) {
		this.goods=goods;
		this.t=t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!Thread.interrupted())
		{
			try {
				synchronized (this) {
					if(!goods.hasProduct)
					{
						wait();
					}
				}
				synchronized (t.product) {
					System.out.println("cosume good");
					goods.hasProduct=false;
					t.product.notify();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}
	
}