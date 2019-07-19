package com.greatlearning.model;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

public class Retailer implements Runnable {
	BlockingQueue<Product> inventory;
	private long id;
	private String name;

	public Retailer(BlockingQueue<Product> inventory) {
		this.inventory = inventory;
	}

	@Override
	public void run() {
		Iterator<Product> itr = inventory.iterator();
		while(itr.hasNext()) {
			try {
				Product product = this.inventory.take();
				System.out.println("Retailer sold: " + product.toString());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*public Product sellProduct() {

	}*/
}