package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.group1.booking.dao.AccountDAO;
import com.group1.booking.impl.AccountDAOImpl;
import com.group1.booking.models.Account;
import com.group1.booking.returnModels.*;

public class Services implements IServices {

	AccountDAO accountDao;

	public void setAccountDAOImpl(AccountDAOImpl accountDAOImpl) {
		this.accountDao = accountDAOImpl;
	}

	public IServices getAccountServices() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IServices as = (IServices) appContext.getBean("Services");
		return as;
	}

	public Login ToLogin(String Username, String Password) {
		// TODO Auto-generated method stub
		return accountDao.ToLogin(Username, Password);
	}

	public Account SearchAccountById(String ACCT_ID) {
		// TODO Auto-generated method stub
		return accountDao.SearchByAccountBy(ACCT_ID);
	}

	public ArrayList<Account> searchAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.searchAllAccounts();
	}

	public String CreateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.CreateAccount(account);
	}

	public static void main(String[] args) {
		IServices ias = new Services().getAccountServices();
		
		//TENGKH: Local testing for login
		Login login = ias.ToLogin("BITUIGA", "bituiga123");
		System.out.println("isSuccess: " + login.getIsSucces());
		System.out.println("Username: " + login.getUsername());
		System.out.println("UserId: " + login.getUserid());
		System.out.println("Role: " + login.getRole());
	}

}
