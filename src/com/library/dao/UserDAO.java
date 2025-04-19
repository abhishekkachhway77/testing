package com.library.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.User;

public class UserDAO {
		private static final String URL = "jdbc:mysql://localhost:3306/library";
		
		private static final String USER = "root";
		
		private static final String PASSWORD = "Abhi123";
		
		//Method to establish a connection
		
		private Connection getConnection() throws SQLException{
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}
		
		//Method to insert a user
		
		public void insertUser(User user) throws SQLException{
			
			String sql ="insert into login(userid,password) values(?,?)";
			
			Connection conn = getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
			
			System.out.println("student inserted Succesfully");
		}
	//Method to retrieve all user
		
		public List<User> getAllUsers() throws SQLException{
			List<User> users = new ArrayList<>();
			
			String sql = "SELECT * FROM login ";
			
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User user = new User(rs.getInt("userid"),rs.getString("password"));
				
				users.add(user);
			}
			return users;
		}
}
