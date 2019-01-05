package com.ignite.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.ignite.bean.Person;
import com.ignite.parser.PersonCustomParser;

public class CustomParserApp1 {
	
	static Logger log = Logger.getLogger(CustomParserApp1.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1;
		try {
			p1 = new Person("Harsha","Sales","harsha@gmail.com","10-08-1988");
			Person p2 = new Person("Vardhan","Manager","vardhan@gmail.com","08-10-1988");
			PersonCustomParser parser = new PersonCustomParser();
			// Not recommended to use + operator
			String result = p1.toCustom() + p2.toCustom(); 
			System.out.println("Resultant String : ");
			System.out.println(result);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("Exception  : "+e);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Exception  : "+e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Exception  : "+e);
		}
		
		
		
		

	}

}
