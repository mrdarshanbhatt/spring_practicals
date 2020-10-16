package com.core.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

	private String uname;
	private int id;

	// Dependency injection...
	@Autowired
	Employee employee;

	// Here User class is DependsUpon the Employee Object it's  also called Tight Coupling

	public User() {
		System.out.println("User Object Created...");
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}


// Tight Coupling  :  Dependent Object
// Loose Coupling : No any Dependency between Object

