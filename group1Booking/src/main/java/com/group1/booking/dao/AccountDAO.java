package com.group1.booking.dao;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;

//Interface for Account
public interface AccountDAO {
	
	public String CreateAccount(Account account);//Return String success/fail
	public String Login(String Username, String Password);//return String Success/fail
	public void UpdateAccount(Account account);
	public Account SearchByAccountBy(String ACCT_ID);
	public ArrayList<Account> searchAllAccounts();
}
