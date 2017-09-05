package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.group1.booking.dao.AccountDAO;
import com.group1.booking.impl.AccountDAOImpl;
import com.group1.booking.models.Account;

public class AccountServices implements IAccountService{

	AccountDAO accountDao;
	public void setAccountDAOImpl(AccountDAOImpl accountDAOImpl) {
		this.accountDao = accountDAOImpl;
	}
	
	public IAccountService getAccountServices(){
		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
		IAccountService as = (IAccountService) appContext.getBean("AccountServices");
		return as;
	}
	
	public String Login(String Username, String Password) {
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("AppContext.xml");
//		AccountDAO accountDAO = (AccountDAO) appContext.getBean("AccountDAOImpl");
//		return Username;
		
		return accountDao.Login(Username, Password);
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
		IAccountService ias = new AccountServices().getAccountServices();
		
//		Account test= ias.SearchAccountById("2017003");
//		ArrayList<Account> accounts = ias.searchAllAccounts();
		Account addAccount = new Account();
		addAccount.setPassword("wazza");
		addAccount.setUserID("1150");
		addAccount.setUsername("wazza");
		System.out.println(ias.CreateAccount(addAccount));
//		System.err.println("testsets1"+ias.SearchAccountById("2017002").getAcctID());
//		System.err.println("testsets2"+ias.SearchAccountById("2017003").getAcctID());
//		System.err.println(accounts.get(0).get_acctID());
	}

}
