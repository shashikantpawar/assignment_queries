package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.UserBO;
import com.nt.dao.UserDAO;
import com.nt.dao.UserDAOFactory;
import com.nt.dto.UserDTO;

public class UserServiceImpl implements UserService {

	public String registerUser(UserBO bo) {
		UserDAO dao = null;
		String result = "User was not registered successfully...try again";
		int count = 0;
 		//
		dao = UserDAOFactory.getInstance();
		count = dao.registerUser(bo);
		System.out.println("ServiceImpl::--"+bo);
		if(count >= 0)
			result = "User reegistration succeeded...";
		return result;
	}

	@Override
	public List retriveData() {
		UserDAO dao = null;
		List<UserDTO> userList;
		List<UserBO> listBO;
		UserDTO dto = null;
		//
		dao = UserDAOFactory.getInstance();
		listBO = dao.retriveData(); 
		userList = new ArrayList<>();
		for(UserBO bo:listBO){
			dto = new UserDTO();
			dto.setUserName(bo.getUserName());
			dto.setFirstName(bo.getFirstName());
			dto.setLastName(bo.getLastName());
			dto.setEmail(bo.getEmail());
			dto.setPhoneNo(bo.getPhoneNo());
			dto.setLocation(bo.getLocation());
			userList.add(dto);
		}
		return userList;
	}

	@Override
	public String deleteUser(String userName) {
		UserDAO dao = null;
		UserDTO dto = null;
		String result = "User was not deleted successfully...try again";
		int count = 0;
 		//
		dao = UserDAOFactory.getInstance();
		count = dao.deleteUser(userName);
		if(count >= 0)
			result = "User deletion succeeded...";
		return result;
	}

	@Override
	public String updateUser(UserBO bo) {
		UserDAO dao = null;
		String result = "User was not updated successfully...try again";
		int count = 0;
 		//
		dao = UserDAOFactory.getInstance();
		count = dao.updateUserInfo(bo);
		if(count >= 0)
			result = "User updated successfully...";
		return result;
	}
		
}
