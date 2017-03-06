package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bo.UserBO;
import com.nt.dto.UserDTO;
import com.nt.service.UserService;
import com.nt.service.UserServiceFactory;

public class RegistrationController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = null;
		UserBO bo = new UserBO();
		String result= null;
		List<UserDTO> userList = null;
		RequestDispatcher rd = null;
		String action = req.getParameter("action");
		//
		if(action.equals("register")){
		bo.setUserName(req.getParameter("username"));
		bo.setFirstName(req.getParameter("first_name"));
		bo.setLastName(req.getParameter("last_name"));
		bo.setEmail(req.getParameter("email"));
		bo.setPassword(req.getParameter("password"));
		bo.setPhoneNo((Long.parseLong(req.getParameter("phone_no"))));
		bo.setLocation(req.getParameter("location"));
		//
		System.out.println("Controller::--"+bo);
		service = UserServiceFactory.getInstance();
		result = service.registerUser(bo);
		//
		userList = service.retriveData(); 
		//
		req.setAttribute("result",result);
		req.setAttribute("userList", userList);
		//
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		}
		else if(action.equals("delete")){
			service = UserServiceFactory.getInstance();
			String userName = req.getParameter("username");
			
			result = service.deleteUser(userName);
			req.setAttribute("result", result);
			userList = service.retriveData();
			req.setAttribute("userList", userList);
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
		else if(action.equals("update")){
			bo.setUserName(req.getParameter("username"));
			bo.setFirstName(req.getParameter("first_name"));
			bo.setLastName(req.getParameter("last_name"));
			bo.setEmail(req.getParameter("email"));
			bo.setPhoneNo((Long.parseLong(req.getParameter("phone_no"))));
			bo.setLocation(req.getParameter("location"));
			//
			System.out.println("==============> update");
			service = UserServiceFactory.getInstance();
			result = service.updateUser(bo);
			//
			
			userList = service.retriveData(); 
			//
			req.setAttribute("result",result);
			req.setAttribute("userList", userList);
			System.out.println("============> after update");
			//
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
