package com.library.model;

public class IssueBook {
	private int id;
	private String name;
	private String publisher;
	private int year;
	private int issuedate;
	private int duedate;
	private int studentid;
	private String status;
	
	
	//Constructor
	
	public IssueBook(int id,String name,String publisher,int year,int issuedate,int duedate,int studentid,String status) {
		this.id=id;
		this.name=name;
		this.publisher=publisher;
		this.year=year;
		this.issuedate=issuedate;
		this.duedate=duedate;
		this.studentid=studentid;
		this.status=status;
	}
	
	
	//setter and getter
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year=year;
	}
	
	public int getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(int issuedate) {
		this.issuedate=issuedate;
	}
	
	public int getDuedate() {
		return duedate;
	}
	public void setDuedate(int duedate) {
		this.duedate=duedate;
	}
	
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid=studentid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}


}
