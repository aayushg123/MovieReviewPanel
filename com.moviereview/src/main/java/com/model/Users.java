package com.model;

import javax.validation.constraints.Size;

public class Users {
	private int userId;
	
	private String userName;
	private String userEmail;
	private String userPassword;
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String userName, String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	public Users(int userId, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
