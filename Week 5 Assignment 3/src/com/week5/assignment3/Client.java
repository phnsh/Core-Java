package com.week5.assignment3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.week5.assignment3.Employee.Department;

@FunctionalInterface
interface FilterEmployeeCondition<T> {
	boolean filter(FilterEmployeeCondition<? super T> t);
}

/*class greaterThan implements Predicate<Employee> {

	@Override
	public boolean test(Employee t) {
		// TODO Auto-generated method stub
		return t.getId() > 70;
	}
}
*/

public class Client {
	
	private static List<Employee> filterEmployees(List<Employee> employeeList, Predicate<Employee> predicate) {
		Iterator<Employee> itr = employeeList.iterator();
		List<Employee> filteredEmployeesList = new ArrayList<>();
		while(itr.hasNext()) {
			Employee emp = itr.next();
			if(predicate.test(emp)) {
				filteredEmployeesList.add(emp);
			}
		}
		
		return filteredEmployeesList;
	}
	
	public static void main(String args[]) {
		
		Scanner scans = new Scanner(System.in);
		double value;
		Department dept;
		
		List<Employee> employeeList = new ArrayList<>();

		employeeList.add(new Employee(12, "employee1", 55, 20_000, Department.HR));
		employeeList.add(new Employee(78, "employee2", 40, 40_000, Department.MARKETING));
		employeeList.add(new Employee(23, "employee3", 42, 55_000, Department.SALES));
		employeeList.add(new Employee(18, "employee4", 25, 60_000, Department.FINANCE));
		employeeList.add(new Employee(18, "employee4", 28, 40_000, Department.SALES));
		employeeList.add(new Employee(18, "employee4", 35, 30_000, Department.HR));
		employeeList.add(new Employee(18, "employee4", 39, 80_000, Department.FINANCE));
		employeeList.add(new Employee(18, "employee4", 28, 20_000, Department.MARKETING));
		employeeList.add(new Employee(18, "employee4", 24, 45_000, Department.HR));
		employeeList.add(new Employee(18, "employee4", 31, 70_000, Department.SALES));
		
		System.out.println("1 -> Filter the employees having age less than the given input value");
		System.out.println("2 -> Filter all the employees having age more than given input value");
		System.out.println("3 -> Filter all the employees having salary more than the given value and belong to the given department");
		int choice = scans.nextInt();
		
		switch(choice) {
		case 1:
			//i. Filter the employees having age less than the given input value.
			System.out.println("Enter the age to sort employee ages lesser than: ");
			value = scans.nextInt();
			System.out.println(filterEmployees(employeeList, emp -> emp.getAge() < value));
			break;
			
		case 2:
			//ii. Filter all the employees having age more than given input value.
			System.out.println("Enter the age to sort employee ages more than: ");
			value = scans.nextInt();
			System.out.println(filterEmployees(employeeList, emp -> emp.getAge() > value));
			break;
			
		case 3:
			//iii. Filter all the employees having salary more than the given value and belong to the given department.
			System.out.println("Enter the salary: ");
			value = scans.nextInt();
			System.out.println("Enter the department: ");
			dept = Department.valueOf(scans.next().toUpperCase());
			System.out.println(filterEmployees(employeeList, emp -> emp.getSalary() > value && dept == emp.getDepartment()));
			break;
			
		case 4:
			//iv. Print the name of the employees whose salary is greater than the input value and belong to the given department.
			System.out.println("Enter the salary: ");
			value = scans.nextInt();
			System.out.println("Enter the department: ");
			dept = Department.valueOf(scans.next().toUpperCase());
			List<Employee> empFilteredList = new ArrayList<>(); // = filterEmployees(employeeList, emp -> emp.getSalary() > value);
			System.out.println(empFilteredList
					.stream()
					.filter(emp -> emp.getSalary() > value && dept == emp.getDepartment())
					.map(Employee :: getDepartment)
					);
			break;
			
		default:
			System.out.println("Incorrect option");
			break;
		}
		//Predicate<Employee> greaterThanPredicate = new greaterThan();
		//System.out.println(filterEmployees(employeeList, age -> age.getAge() < 40));
		scans.close();
	}
}