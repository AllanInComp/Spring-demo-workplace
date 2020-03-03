package com.allanudemy.jackson_databind_json_demo.demo;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class FullDriver {

	public static void main(String[] args) {
    	try {
    	   	//create mapper
			ObjectMapper objm = new ObjectMapper();
			
			//json to pojo
			StudentFull myStudent =objm.readValue(new File("data/sample-full.json"), StudentFull.class);
			System.out.println(myStudent);
			
			//pojo to json
			myStudent.setActive(false);
			objm.enable(SerializationFeature.INDENT_OUTPUT);
			objm.writeValue(new File("data/sample-full-output.json"), myStudent);
			
			
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
