package com.nt.dao;

public class UserDAOFactory {
	public static UserDAO getInstance(){
		return new UserDAOImpl();
	}
}
