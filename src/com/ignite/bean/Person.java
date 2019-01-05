package com.ignite.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
	String name;
	String role;
	String email;
	Date dob;
	SimpleDateFormat sdf;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public Person(String name, String role, String email, Date dob) {
		super();
		this.name = name;
		this.role = role;
		this.email = email;
		this.dob = dob;
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return sdf.format(dob);
	}
	public void setDob(String dob) throws ParseException {
		this.dob = sdf.parse(dob);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", role=" + role + ", email=" + email
				+ ", dob=" + this.getDob() + "]";
	}
	
	public String toCSV(){
		return "" + name + "," + role + "," + email
				+ "," + this.getDob() + "]";
	}
	
}
