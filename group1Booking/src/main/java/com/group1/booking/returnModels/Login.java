package com.group1.booking.returnModels;

public class Login {
	String isSucces;
	String role;
	String custid;
	String username;
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	String accountId;

	public String getIsSucces() {
		return isSucces;
	}

	public void setIsSucces(String isSucces) {
		this.isSucces = isSucces;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}
}
