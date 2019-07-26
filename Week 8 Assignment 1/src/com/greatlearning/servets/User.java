package com.greatlearning.servets;

public class User {
	private long id;
	private String name;
	private int age;
	private String location;
	public User(long id, String name, int age, String location) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.location = location;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}