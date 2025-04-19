package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.IssueBook;


public class IssueBookDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "Abhi123";
	
	//Method to establish a Connection
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	//Method to insert a student 
	
	public void insertIssueBook(IssueBook issueBook) throws SQLException{
		
		String sql = "insert into issuebook1(id,name,publisher,year,issuedate,duedate,studentid,status) values(?,?,?,?,?,?,?,?)";
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, issueBook.getId());
		pstmt.setString(2, issueBook.getName());
		pstmt.setString(3, issueBook.getPublisher());
		pstmt.setInt(4, issueBook.getYear());
		pstmt.setInt(5, issueBook.getIssuedate());
		pstmt.setInt(6, issueBook.getDuedate());
		pstmt.setInt(7, issueBook.getStudentid());
		pstmt.setString(8, issueBook.getStatus());
		
		pstmt.executeUpdate();
		
		System.out.println("Book inserted Successfully");
	}
	
	//Method to retrieve all Student
	
	public List<IssueBook> getAllIssueBooks() throws SQLException{
		
		List<IssueBook> issueBooks = new ArrayList<>();
		
		String sql = "SELECT * FROM issuebook1";
		
		Connection conn = getConnection();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			IssueBook issueBook = new IssueBook(rs.getInt("id"),rs.getString("name"),rs.getString("publisher"),rs.getInt("year"),rs.getInt("issuedate"),rs.getInt("duedate"),rs.getInt("studentid"),rs.getString("status"));
			issueBooks.add(issueBook);
		}
		
		return issueBooks;
	}
	
	
	// Update book issue details
    public void updateIssueBook(IssueBook issueBook) throws SQLException {
        String sql = "UPDATE issuebook1 SET name=?, publisher=?, year=?, issuedate=?, duedate=?, studentid=?, status=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, issueBook.getName());
            pstmt.setString(2, issueBook.getPublisher());
            pstmt.setInt(3, issueBook.getYear());
            pstmt.setInt(4, issueBook.getIssuedate());
            pstmt.setInt(5, issueBook.getDuedate());
            pstmt.setInt(6, issueBook.getStudentid());
            pstmt.setString(7, issueBook.getStatus());
            pstmt.setInt(8, issueBook.getId());
            pstmt.executeUpdate();
            System.out.println("Book issue record updated successfully");
        }
    }
    
    
    // Delete book issue record
    public void deleteIssueBook(int id) throws SQLException {
        String sql = "DELETE FROM issuebook1 WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Book issue record deleted successfully");
        }
    }
}
