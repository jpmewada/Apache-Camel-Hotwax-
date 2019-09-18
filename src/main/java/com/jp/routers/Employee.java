package com.jp.routers;

import com.google.gson.Gson;

public class Employee {
	private String name;
	private double salary;
	private int age;
	private int id;
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param age
	 * @param image
	 */
	public Employee(String name, double salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
																	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	 public String toJson() {
		 Gson gson = new Gson();
		 return gson.toJson(this);
	 }
	 
	 public static Employee toEmployee(String json) {
		 Gson gson = new Gson();
		 return gson.fromJson(json, Employee.class);
	 }
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", id=" + id + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	 
}