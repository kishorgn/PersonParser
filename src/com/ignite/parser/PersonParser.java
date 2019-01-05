package com.ignite.parser;

import java.text.ParseException;
import java.util.ArrayList;

import com.ignite.bean.Person;

public class PersonParser {
	String string;
	
	public void setString(String string){
		this.string=string;
	}
	
	public ArrayList<Person> getPersons() throws ParseException{
		ArrayList<Person> persons = new ArrayList<Person>();
		String[] rows = string.split("\n");
		
		for(String row : rows){
			Person p = new Person();
			
			String[] cols = row.split(",");
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
		
		String[] cols = row.split(",");
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
