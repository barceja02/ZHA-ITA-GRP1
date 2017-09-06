package com.group1.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;
import com.group1.booking.returnModels.Login;;

public interface IServices {
	public Login ToLogin(String Username, String Password);

	public Account SearchAccountById(String Username);

	public ArrayList<Account> searchAllAccounts();

	public String CreateAccount(Account account);
}
