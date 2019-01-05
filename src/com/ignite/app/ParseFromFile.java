/*
 * 
 * This program read csv string from file and create objects.
 * And serialize the object's graph into a disk file 
 * 
 */

package com.ignite.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ignite.bean.Person;
import com.ignite.parser.PersonParser;

public class ParseFromFile {

	static Logger log = Logger.getLogger(ParseFromFile.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fileReader = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try{
			fileReader = new FileReader("input/person1.txt");
			StringBuilder personBuilder = new StringBuilder();
			
			// Read textfile content to string
			int ch=0;
			do{
				ch = fileReader.read();
				if(ch!=-1){
					personBuilder.append((char)ch);
				}
			}while(ch!=-1);
			String strPersons = personBuilder.toString();
			log.debug(strPersons);
			
			PersonParser personParser = new PersonParser();
			personParser.setString(strPersons);
			ArrayList<Person> persons = personParser.getPersons();
			System.out.println("Parsed Persons collection : ");
			
			fos = new FileOutputStream("output/person1.dat");
			oos = new ObjectOutputStream(fos);
			
			for(Person p : persons){
				log.debug(p);
				oos.writeObject(p);
			}
			 
			
			
			
			
			
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
