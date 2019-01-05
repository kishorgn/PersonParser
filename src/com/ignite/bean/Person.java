package com.ignite.bean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Person implements Serializable {
	String name;
	String role;
	String email;
	Date dob;
	SimpleDateFormat sdf ;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}
	public Person(String name, String role, String email, String dob) throws ParseException {
		super();
		this.name = name;
		this.role = role;
		this.email = email;
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		this.dob = sdf.parse(dob);
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
				+ ", dob=" + getDob() + "]";
	}
	
	public String toCSV(){
		return "" + name + "," + role + "," + email
				+ "," + this.getDob() + "\n";
	}
	
	public String toCustom() throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		prop.load(new FileReader("config.prop"));
		String fd = prop.getProperty("fielddelimiter");
		String rd = prop.getProperty("recorddelimiter");
		return "" + name + fd + role + fd + email
				+ fd + this.getDob() + rd;
	}
	
}
