package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;


import com.library.model.Book;

public class BookDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "Abhi123";
	
	//Method to establish a Connection 
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	//Method to insert a Book
	
	public void insertBook(Book book) throws SQLException{
		String sql = "INSERT INTO books(id,name,publisher,price,year,status) values(?,?,?,?,?,?)";
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1,book.getId());
		pstmt.setString(2, book.getName());
		pstmt.setString(3,book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.setInt(5, book.getYear());
		pstmt.setString(6,book.getStatus());
		
		pstmt.executeUpdate();
		
		System.out.println("Book inserted Successfully");
		
		
		
	}
	
	//Method to retrieve all Book
	
	public List<Book> getAllBooks() throws SQLException{
		
		List<Book> books  = new ArrayList<>();
		
		String sql = "SELECT * FROM books";
		
		Connection conn = getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Book book = new Book(rs.getInt("id"),rs.getString("name"),rs.getString("publisher"),rs.getInt("price"),rs.getInt("year"),rs.getString("status")); 
			
			books.add(book);
		}
		return books;
	
	}
	
	// Update Method
	public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE books SET name = ?, publisher = ?, price = ?, year = ?, status = ? WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getName());
            pstmt.setString(2, book.getPublisher());
            pstmt.setInt(3, book.getPrice());
            pstmt.setInt(4, book.getYear());
            pstmt.setString(5, book.getStatus());
            pstmt.setInt(6, book.getId());
            pstmt.executeUpdate();
            System.out.println("Book updated successfully");
        }
    }

	
	//Delete method
	
	
	public void deleteBook(int bookId) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
            System.out.println("Book deleted successfully");
        }
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
