package com.group1.booking.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.group1.booking.returnModels.Login;

public class appControl {

	
	public static void main(String[] args) {
		IServices as = getAccountServices();
		Login loginresult = as.ToLogin("TENGKH", "tengkh123");
		System.err.println(loginresult.getIsSucces());
	}	
	
	
	public static IServices getAccountServices(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IServices as = (IServices) appContext.getBean("Services");
		return as;
	}
}
