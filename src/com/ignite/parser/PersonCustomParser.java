package com.ignite.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import com.ignite.bean.Person;

public class PersonCustomParser {
	String string;
	static String fd;
	static String rd;
	
	public PersonCustomParser() throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		FileReader fileReader = new FileReader("config.prop");
		prop.load(fileReader);
		fd = prop.getProperty("fielddelimiter");
		rd = prop.getProperty("recorddelimiter");
	}
	
	public void setString(String string){
		this.string=string;
	}
	
	public ArrayList<Person> getPersons() throws ParseException{
		ArrayList<Person> persons = new ArrayList<Person>();
		String[] rows = string.split(rd);
		
		for(String row : rows){
			Person p = new Person();
			
			String[] cols = row.split(fd);
			for(int c=0;c<cols.length;c++){
				if(c==0){
					p.setName(cols[c]);
				}
				if(c==1){
					p.setRole(cols[c]);
				}
				if(c==2){
					p.setEmail(cols[c]);
				}
				if(c==3){
					p.setDob(cols[c]);
				}
			}
			persons.add(p);
		}
		
		return persons;
	}
	
	public static Person getPerson(String row) throws ParseException{
		Person p = new Person();
		
		String[] cols = row.split(fd);
		for(int c=0;c<cols.length;c++){
			if(c==0){
				p.setName(cols[c]);
			}
			if(c==1){
				p.setRole(cols[c]);
			}
			if(c==2){
				p.setEmail(cols[c]);
			}
			if(c==3){
				p.setDob(cols[c]);
			}
		}
		return p;
	}
}
