package com.greatlearning.model;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;


public class Distributor implements Runnable {
	BlockingQueue<Product> inventory;
	private long id;
	private String name;
	List<Product> productList;
	private static int listIter = -1;
	
	public Distributor(BlockingQueue<Product> inventory) {
		this.inventory = inventory;
	}
	
	@Override
	public void run() {
		Iterator<Product> itr = productList.iterator();
		while(itr.hasNext()) {
			try {
				Product product = updateInventory();
				inventory.put(itr.next());
				System.out.println("Distributor added: " + product.toString());
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateInventory(List<Product> product) {
		this.productList = product;
	}
	
	public Product updateInventory() {
		listIter++;
		return this.productList.get(listIter);
	}
}