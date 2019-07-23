package com.greatlearning.model;

public class Item {

	private long id;
	private String name;
	private double basePrice;
	private String desc;

	public Item(long id, String name, double basePrice, String desc) {
		this.id = id;
		this.name = name;
		this.basePrice = basePrice;
		this.desc = desc;
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
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
}