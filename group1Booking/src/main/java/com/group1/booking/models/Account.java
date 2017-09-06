package com.group1.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="GRP1_ACCOUNT")
public class Account {
	// @Column(name = "USER_ID")
	String custID;
	// @Id
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	int acctID;
	// @Column(name="USERNAME")
	String username;
	// @Column(name="PASSWORD")
	String password;

	// @Column(name="ROLE")
	String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCustID() {
		return custID;
	}

	public void setCustID(String custID) {
		this.custID = custID;
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
