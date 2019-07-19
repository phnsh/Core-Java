package com.greatlearning.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.greatlearning.model.Distributor;
import com.greatlearning.model.Product;
import com.greatlearning.model.Retailer;

public class InventoryManagementClient  {
	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Product> inventory = new ArrayBlockingQueue<Product>(10);
		//new Distributor(new Product(5));
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(10, "Product 1", 300, "Product 1 desc"));
		productList.add(new Product(40, "Product 2", 200, "Product 2 desc"));
		productList.add(new Product(45, "Product 3", 300, "Product 3 desc"));
		productList.add(new Product(86, "Product 4", 300, "Product 4 desc"));
		productList.add(new Product(323, "Product 5", 300, "Product 5 desc"));
		productList.add(new Product(34, "Product 6", 300, "Product 6 desc"));
		productList.add(new Product(54, "Product 7", 300, "Product 7 desc"));
		productList.add(new Product(98, "Product 8", 300, "Product 8 desc"));
		productList.add(new Product(938, "Product 9", 300, "Product 9 desc"));
		productList.add(new Product(203, "Product 10", 300, "Product 10 desc"));
		
		Distributor distributor = new Distributor(inventory);
		Retailer retailer = new Retailer(inventory);
		distributor.updateInventory(productList);
							
		Thread t1 = new Thread(distributor);
		Thread t2 = new Thread(retailer);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}