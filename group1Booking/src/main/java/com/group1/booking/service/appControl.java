package com.group1.booking.service;

import java.io.IOException;
import java.io.StringReader;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.returnModels.Login;

public class appControl {

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		IServices as = getAccountServices();
//		Login loginresult = as.ToLogin("TENGKH", "tengkh123");
//		System.err.println(loginresult.getIsSucces());
		
		String json = "{\"isSuccess\": \"true\",\"role\": \"userkoto\",\"userId\": 123}";
		ObjectMapper map = new ObjectMapper();
		Object input = map.readValue(json,Object.class);
		JsonNode rootNode = new ObjectMapper().readTree(new StringReader(json));
		JsonNode aField = rootNode.get("role");
		System.out.println(aField.toString());
	}	
	
	
	public static IServices getAccountServices(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IServices as = (IServices) appContext.getBean("Services");
		return as;
	}
}
