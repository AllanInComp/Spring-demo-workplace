package com.allanudemy.jackson_databind_json_demo.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class LiteDriver 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	//create mapper
        	ObjectMapper objm = new ObjectMapper();
        	
        	//json to pojo
        	Student myStudent =objm.readValue(new File("data/sample-lite.json"), Student.class);
        	System.out.println(myStudent);
        	
        	//pojo to json
        	myStudent.setActive(false);
        	objm.enable(SerializationFeature.INDENT_OUTPUT);
        	objm.writeValue(new File("data/sample-lite-output.json"), myStudent);
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }
}
