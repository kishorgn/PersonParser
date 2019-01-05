package com.ignite.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ignite.bean.Person;
import com.ignite.parser.PersonParser;
import com.ignite.process.PersonProcessor;

public class DeserializeDemo {
	static Logger log = Logger.getLogger(DeserializeDemo.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		StringBuilder personBuilder = new StringBuilder();
		try{
			fis = new FileInputStream("output/person1.dat");
			ois = new ObjectInputStream(fis);
			while(fis.available()>0){
				Person p = (Person)ois.readObject();
				personBuilder.append(p.toCSV());
			}
			String strPerson = personBuilder.toString();
			
			log.debug("Deserialized objects string : \n"+strPerson);
			
			PersonParser personParser = new PersonParser();
			personParser.setString(strPerson);
			ArrayList<Person> persons = personParser.getPersons();
			System.out.println("Person Objects deserialized from file");
			for(Person p : persons){
				System.out.println(p);
			}
		}
		catch(FileNotFoundException e){
			log.error("Exception 1 : "+e);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Exception 2 : "+e);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			log.error("Exception 3 : "+e);
		}
		catch(IOException e){
			log.error("Exception 4 : "+e);
		}
		finally {
			try{
				ois.close();
				fis.close();
			}
			catch(IOException e){
				log.error("Exception 5 : "+e);
			}
		}
		
		PersonProcessor personProcessor = new PersonProcessor();
		

	}

}
