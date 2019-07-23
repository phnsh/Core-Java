package com.greatlearning.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.greatlearning.model.Bidder;
import com.greatlearning.model.Item;

public class Auction {
	public static void main(String[] args) throws InterruptedException {
		List<Item> itemsList = new ArrayList<>();
		CountDownLatch latch = new CountDownLatch(4);
		
		itemsList.add(new Item(1, "Swift-Dezire", 5_00_000, "good condition car"));
		itemsList.add(new Item(2, "Sony-Bravia", 10_000, "in excellent condition"));
		itemsList.add(new Item(3, "Bajaj- Pulsar", 30_000, "run for 20000 Kms"));
		itemsList.add(new Item(4, "Macbook-Pro", 50_000, "one year old laptop. Sparingly used"));
		
		List<Bidder> biddersList = new ArrayList<>();
		
		Bidder bidder1 = new Bidder(1, "Vinay" , latch);
		Bidder bidder2 = new Bidder(2, "Krishna" , latch);
		Bidder bidder3 = new Bidder(3, "Mohan" , latch);
		Bidder bidder4 = new Bidder(4, "Rohan" , latch);
		
		biddersList.add(bidder1);
		biddersList.add(bidder2);
		biddersList.add(bidder3);
		biddersList.add(bidder4);
		
		Thread t1 = new Thread(bidder1);
		Thread t2 = new Thread(bidder2);
		Thread t3 = new Thread(bidder3);
		Thread t4 = new Thread(bidder4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		Iterator<Item> itemsIterator = itemsList.iterator();
		//Iterator<Bidder> bidItr = biddersList.iterator();
		
		List<Double> biddersPrice = new ArrayList<>();
		Scanner scans = new Scanner(System.in);
		int index = 0;
		double tempPrice = 0;
		while(itemsIterator.hasNext()) {
			Item item = itemsIterator.next();
			Iterator<Bidder> bidItr = biddersList.iterator();
			System.out.println("=============" + item.getName() + " for Sale, Base Price - " + item.getBasePrice() + "================");
			
			while(bidItr.hasNext()) {
				Bidder bidder = bidItr.next();
				System.out.println("Bidder - " + bidder.getName());
				System.out.println("===============Please enter your bid price, Base price - " + item.getBasePrice() +" ==========");
				biddersPrice.add(index, scans.nextDouble());
				index++;
			}
			System.out.println(
					"============" + item.getName() + " sold to " + biddersList.get(biddersPrice.indexOf(Collections.max(biddersPrice))).getName()
					+ " - " + Collections.max(biddersPrice) + "===================");
			index = 0;
		}
		scans.close();
	}
}
