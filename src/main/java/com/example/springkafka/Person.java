package com.example.springkafka;

public class Person {

	private String firstName;
	private String secondName;
	private int id;
	
	public Person() {
	}
	
	public Person(int id, String firstName, String secondName) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", secondName=" + secondName + ", id=" + id + "]";
	}

}
