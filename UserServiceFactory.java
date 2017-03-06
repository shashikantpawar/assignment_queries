package com.nt.service;

public class UserServiceFactory {
	public static UserService getInstance(){
		return new UserServiceImpl();
	}
}
