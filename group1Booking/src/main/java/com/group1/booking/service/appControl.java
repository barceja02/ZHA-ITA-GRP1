package com.group1.booking.service;

import java.io.IOException;
import java.io.StringReader;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.models.Account;
import com.group1.booking.returnModels.Login;

public class appControl {

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
//		IServices as = getAccountServices();
		
		//TENGKH 20170905: testing login transaction
		/*Login loginresult = as.ToLogin("BURGOKA", "burgoka123");
		String json = "{\"isSuccess\": \"true\",\"role\": \"userkoto\",\"userId\": 123}";
		System.err.println(loginresult.getRole());
		System.err.println(loginresult.getUsername());
		System.err.println(loginresult.getCustid());*/
		
		//TENGKH 20170905: testing search account by
		Account accountById = as.SearchAccountById("BURGOKA");
		System.err.println(accountById.getUsername());
		System.err.println(accountById.getPassword());
		System.err.println(accountById.getAcctID());
		System.err.println(accountById.getRole());
		
		
	}	
	
	
	public static IServices getAccountServices(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IServices as = (IServices) appContext.getBean("Services");
		return as;
	}
}
