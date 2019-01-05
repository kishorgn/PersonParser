package com.ignite.process;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;

import com.ignite.bean.Person;
import com.ignite.parser.PersonParser;

public class PersonProcessor {
	
	/**
	 * Write Person - Object Serialized and stored into file 
	 * @param person - object which is to be serialized and stored in to file
	 * @param file - in which the serialized object is to be stored
	 * @throws - FileNotFoundException user don't have permission to access the file 
	 * @throws IOException when the disk file is not allowing to write
	 */
	public void writePersonObject(Person person, String file) throws FileNotFoundException,IOException{
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(file,true);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
		}
		finally{
			oos.close();
			fos.close();
		}
		
	}
	// 
	/**
	 * Write Person object into CSV file
	 * @param person - which you wish to convert into CSV
	 * @param file - into which you wish to store the CSV content
	 * @throws IOException 
	 */
	public void writeObject(Person person, String file) throws IOException{
		FileWriter writer = null;
		String csv = person.toCSV();
		try{
			writer = new FileWriter(file, true);
			writer.write(csv);
		}
		finally {
			writer.close();
		}
	}
	
	/**
	 * Read Person - Object from file [De-Serialization] and return String
	 * @param file - from which you wish to read the Serialized object graph
	 * @return the deserialized object in the form of String
	 * @throws IOException 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException 
	 */
	public String getPersonCSV(String file) throws FileNotFoundException, IOException, ClassNotFoundException{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		StringBuilder strPersons = new StringBuilder();
		String res = "";
		try{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			while(fis.available()>0){
				Person p = (Person)ois.readObject();
				strPersons.append(p.toCSV());
			}
			res = strPersons.toString();
		}
		finally{
			fis.close();
			ois.close();
		}
		return res;
	}
	// 
	/**
	 * Read Person - CSV from file and return Object.
	 * @param file - from which file to read
	 * @return ArrayList of Person objects
	 * @throws FileNotFoundException - when file not found in the specified location
	 * @throws ParseException - when the string is not in the specified format
	 * @throws IOException - When the file not allowed to open / close
	 */
	public ArrayList<Person> getPersonObjects(String file) throws FileNotFoundException, ParseException, IOException{
		ArrayList<Person> persons = null;
		FileReader fileReader = null;
		try{
			persons = new ArrayList<>();
			fileReader = new FileReader(file);
			StringBuilder personBuilder= new StringBuilder();
			int ch;
			do{
				ch=fileReader.read();
				if(ch!=-1){
					personBuilder.append((char)ch);
				}
			}while(ch!=-1);
			
			String strPerson = personBuilder.toString();
			
			PersonParser personParser = new PersonParser();
			personParser.setString(strPerson);
			persons = personParser.getPersons();
		}
		finally{
			fileReader.close();
		}
		return persons;
	}

}
