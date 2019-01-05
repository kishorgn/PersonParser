package com.ignite.app;

import java.text.ParseException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ignite.bean.Person;
import com.ignite.parser.PersonParser;

public class SimpleParserTest1 {

	static Logger log = Logger.getLogger(SimpleParserTest1.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Collection Parse Test
		String strPersons="Kishor, Trainer, kishorgn@gmail.com, 03-03-2003\n"+
						  "Koushik, Student, koushikgn@gmail.com, 10-09-2010\n"+
						  "Swathi, Teacher, swathi@gmail.com, 02-02-2002";
		PersonParser personParser = new PersonParser();
		personParser.setString(strPersons);
		try {
			ArrayList<Person> persons = personParser.getPersons();
			System.out.println("Parsed Persons collection : ");
			for(Person p : persons){
				System.out.println(p);
			}
		} 
		
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("Exception while parsing collection : "+e);
		}
		
		// Single Person Parse Test
		String strPerson = "Koushik, Student, koushikgn@gmail.com, 10-09-2010";
		try {
			Person person = PersonParser.getPerson(strPerson);
			System.out.println("Parsed single person :\n"+person);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("Exception while parsing single person : "+e);
		}

	}

}
