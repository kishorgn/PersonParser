package com.ignite.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ignite.bean.Person;
import com.ignite.process.PersonProcessor;

public class PersonProcessorTest1 {

	static Logger log = Logger.getLogger(PersonProcessorTest1.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonProcessor personProcessor = new PersonProcessor();
		try {
//			Person person = new Person("Mahesh", "Accountant", "mahesh@gmail.com", "21-08-1990");
//			System.out.println("Saving the person object to file : "+person);
//			personProcessor.writePersonObject(person, "output/person1.dat");
//			System.out.println("Saved successfully\n\n");
			
			ArrayList<Person> persons = personProcessor.getPersonObjects("input/person1.txt");
			System.out.println("Read persons information from CSV : ");
			for(Person p : persons){
				System.out.println(p);
			}
			
			System.out.println(personProcessor.getPersonCSV("output/person1.dat"));
			
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("Exception 1 : "+e);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Exception 2 : "+e);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Exception 3 : "+e);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Exception 4 : "+e);
		}

	}

}
