package com.library.service;

import java.sql.SQLException;
import java.util.List;



import com.library.dao.IssueBookDAO;
import com.library.model.IssueBook;


public class IssueBookService {
	private IssueBookDAO issueBookDAO;
	
	//constructor
	
	public IssueBookService() {
		this.issueBookDAO = new IssueBookDAO();
	}
	
	//Business logic to insert issue book
	
	public void addIssueBook(IssueBook issueBook) throws SQLException{
		issueBookDAO.insertIssueBook(issueBook);
	}
	
	//Business logic to fetch all issue book
	
	public List<IssueBook> fetchAllIssueBook() throws SQLException{
		return issueBookDAO.getAllIssueBooks();
	}
	
	
	 // Business logic to update an issued book
    public void updateIssueBook(IssueBook issueBook) throws SQLException {
        issueBookDAO.updateIssueBook(issueBook);
    }
    
   
 // Business logic to delete an issued book
    public void deleteIssueBook(int id) throws SQLException {
        issueBookDAO.deleteIssueBook(id);
    }

}

