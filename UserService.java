package com.nt.service;

import java.util.List;

import com.nt.bo.UserBO;

public interface UserService {				
	public String registerUser(UserBO bo);
	public List retriveData();
	public String deleteUser(String userName);
	public String updateUser(UserBO bo);
}
