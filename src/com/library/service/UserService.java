package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.UserDAO;

import com.library.model.User;

public class UserService {
	private UserDAO userDAO;
	
	//constructor
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	//Business logic to insert student
	
	public void addUser(User user) throws SQLException{
		userDAO.insertUser(user);
	}
	//Business Logic fetch all student 
	
	public List<User> fetchAllUsers() throws SQLException{
		return userDAO.getAllUsers();
	}
}
