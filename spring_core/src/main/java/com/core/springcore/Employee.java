package com.core.springcore;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String ename;
	private int eid;

	public Employee() {
		System.out.println("Employee object created...");
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

}
