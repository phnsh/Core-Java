package com.greatlearning.model;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Bidder implements Runnable {
	private long id;
	private String name;
	private CountDownLatch countDownLatch;
	private double price;
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	Scanner scans = new Scanner(System.in);
	
	public Bidder(long id, String name, CountDownLatch countDownLatch) {
		this.id = id;
		this.name = name;
		this.countDownLatch = countDownLatch;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.countDownLatch.countDown();
	}
	
	
}
