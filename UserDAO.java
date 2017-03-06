package com.nt.dao;

import java.util.List;

import com.nt.bo.UserBO;

public interface UserDAO {
	public int registerUser(UserBO bo);
	public List retriveData();
	public int updateUserInfo(UserBO bo);
	public int deleteUser(String  userName);
}
