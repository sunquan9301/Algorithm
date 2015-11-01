package com.sun.Thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiGoodsWaitAndNotify {
	GoodsSet goodsSet = new GoodsSet();
	ProductGoods pro = new ProductGoods(goodsSet, this);
	CosumerGoods cos = new CosumerGoods(goodsSet, this);
	ExecutorService exec = Executors.newCachedThreadPool();

	public MultiGoodsWaitAndNotify() throws InterruptedException {
		exec.execute(pro);
		exec.execute(cos);
		TimeUnit.SECONDS.sleep(1);
		exec.shutdown();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new MultiGoodsWaitAndNotify();
	}

}

class GoodsSet {
	int maxCapa = 5;
	int nowCapa = 0;
	ArrayList<GoodsMulti> Set = new ArrayList<GoodsMulti>(5);
}

class GoodsMulti {
	public int id;

	public GoodsMulti(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:	" + id;
	}
}

class ProductGoods implements Runnable {
	public MultiGoodsWaitAndNotify m;
	public GoodsSet goodsSet;
	public int count = 0;

	public ProductGoods(GoodsSet goodsSet, MultiGoodsWaitAndNotify m) {
		// TODO Auto-generated constructor stub
		this.goodsSet = goodsSet;
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.interrupted()) {
			synchronized (this) {
				if (goodsSet.nowCapa == goodsSet.maxCapa) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("product goods");
			synchronized (this.m.cos) {

				goodsSet.Set.add(new GoodsMulti(count++));
				goodsSet.nowCapa++;
				if (goodsSet.nowCapa == goodsSet.maxCapa) {
					m.cos.notifyAll();
				}
			}

		}
	}

}

class CosumerGoods implements Runnable {
	MultiGoodsWaitAndNotify m;
	GoodsSet goodsSet;

	public CosumerGoods(GoodsSet goodsSet, MultiGoodsWaitAndNotify m) {
		// TODO Auto-generated constructor stub
		this.goodsSet = goodsSet;
		this.m = m;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.interrupted()) {
			synchronized (this) {
				if (goodsSet.nowCapa == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("cosumeGoods");
			synchronized (m.pro) {
				GoodsMulti g = goodsSet.Set.get(goodsSet.Set.size() - 1);
				System.out.println(g);
				goodsSet.Set.remove(g);
				goodsSet.nowCapa--;
				if (goodsSet.nowCapa == 0) {
					m.pro.notify();
				}

			}
		}
	}

}