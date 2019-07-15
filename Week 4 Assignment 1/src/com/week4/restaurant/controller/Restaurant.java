package com.week4.restaurant.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.week4.restaurant.model.Dish;

public class Restaurant {
	public static void main(String args[]) {
		
		Scanner scans = new Scanner(System.in);
		List<Dish> dishesList = new ArrayList<>();
		
		dishesList.add(new Dish(5, "Neer-Dosa", 50, 100));
		dishesList.add(new Dish(10, "dish2", 500, 50));
		dishesList.add(new Dish(4, "dish3", 350, 30));
		dishesList.add(new Dish(3, "dish3", 250, 58));
		
		System.out.println("=================Welcome=====================");
		System.out.println("Please choose from the below options");
		System.out.println("1 => To sort the dishes in the increasing order of calories"
				+ "\n2 => To sort the dishes in the decreasing order of calories"
				+ "\n3 => To sort the dishes in the increasing order of price"
				+ "\n4 => To sort the dishes in the decreasing order of price");
		
		int userChoice = scans.nextInt();
		switch(userChoice) {
		case 1:  
			Comparator<Dish> compareByIncCalories = (Dish o1, Dish o2) -> o1.getCalories().compareTo(o2.getCalories());
			Collections.sort(dishesList, compareByIncCalories);
			for (Dish s : dishesList) {
				System.out.println(s.toString());
			}
			break;
			
		case 2:
			Comparator<Dish> compareByDecCalories = (Dish o1, Dish o2) -> o1.getCalories().compareTo(o2.getCalories());
			Collections.sort(dishesList, compareByDecCalories);
			Collections.reverse(dishesList);
			for (Dish s : dishesList) {
				System.out.println(s.toString());
			}
			break;
			
		case 3:
			Comparator<Dish> compareByIncPrice = (Dish o1, Dish o2) -> o1.getPrice().compareTo(o2.getPrice());
			Collections.sort(dishesList, compareByIncPrice);
			for (Dish s : dishesList) {
				System.out.println(s.toString());
			}
			break;
			
		case 4:
			Comparator<Dish> compareByDecPrice = (Dish o1, Dish o2) -> o1.getPrice().compareTo(o2.getPrice());
			Collections.sort(dishesList, compareByDecPrice);
			Collections.reverse(dishesList);
			for (Dish s : dishesList) {
				System.out.println(s.toString());
			}
			break;
			
		default:
			System.out.println("Please choose an option between 1 and 4");
			break;
		}
	}
}