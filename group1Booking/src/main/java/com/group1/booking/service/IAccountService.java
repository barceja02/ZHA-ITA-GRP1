package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;;

public interface IAccountService {
	public String Login(String Username, String Password);
	public Account SearchAccountById(String ACCT_ID);
	public ArrayList<Account> searchAllAccounts();
	public String CreateAccount(Account account);
}
