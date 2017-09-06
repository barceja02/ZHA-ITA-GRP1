package com.group1.booking.dao;

import java.util.ArrayList;
import java.util.List;

import com.group1.booking.models.Account;
import com.group1.booking.returnModels.Login;

//Interface for Account
public interface AccountDAO {

	public String CreateAccount(Account account);

	public Login ToLogin(String Username, String Password);

	public void UpdateAccount(Account account);

	public Account SearchByAccountBy(String Username);

	public ArrayList<Account> searchAllAccounts();
}
