package com.sun.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockQueue {
	GoodsQueue gq=new GoodsQueue();
	Productor p=new Productor(gq);
	Cosumerr c=new Cosumerr(gq);
	ExecutorService exec=Executors.newCachedThreadPool();
	public BlockQueue() throws InterruptedException
	{
		exec.execute(c);
		exec.execute(p);
		TimeUnit.SECONDS.sleep(1);
		exec.shutdown();
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new BlockQueue();
	}

}
class GoodsQueue extends LinkedBlockingQueue<GoodsUnit>{
}
class GoodsUnit{
	public int id;
	public GoodsUnit(int id)
	{
		this.id=id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id"+id;
	}
}
class Productor implements Runnable{
	public int id=0;
	GoodsQueue queue;
	public Productor(GoodsQueue queue)
	{
		this.queue=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted())
			{
				GoodsUnit unit=new GoodsUnit(id++);
				System.out.println(unit);
				queue.put(unit);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
class Cosumerr implements Runnable{
	GoodsQueue queue;
	public Cosumerr(GoodsQueue queue)
	{
		this.queue=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.interrupted())
			{
				GoodsUnit unit=queue.take();
				System.out.println(unit);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}