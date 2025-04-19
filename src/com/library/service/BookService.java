package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.BookDAO;

import com.library.model.Book;




public class BookService {
	private BookDAO bookDAO;
	
	
	//constructor
	
	public BookService() {
		this.bookDAO = new BookDAO();
	}
	
	
	//Business logic to insert book
	public void addBook(Book book) throws SQLException{
		bookDAO.insertBook(book);
	}
	
	
	//Business logic to fetch all students
	
	public List<Book> fetchAllBooks() throws SQLException{
		return bookDAO.getAllBooks();
	}
	
	//Business Logic to update book
	 public void updateBook(Book book) throws SQLException {
	        bookDAO.updateBook(book);
	    }

	//Business logic to delete book
	 public void deleteBook(int bookId) throws SQLException {
	        bookDAO.deleteBook(bookId);
	    }
}
