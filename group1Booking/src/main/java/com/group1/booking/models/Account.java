package com.group1.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="GRP1_ACCOUNT")
public class Account{
//	@Column(name = "USER_ID")
	String userID;
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int acctID;
//	@Column(name="USERNAME")
	String username;
//	@Column(name="PASSWORD")
	String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	
	
}
