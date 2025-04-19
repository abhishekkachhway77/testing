package com.library.model;

public class Student {
	private int studentid;
	private String name;
	private String course;
	private String branch;
	private String semester;
	  
	
	//Constructor
	public Student(int studentid,String name,String course,String branch,String semester) {
		this.studentid=studentid;
		this.name=name;
		this.course = course;
		this.branch = branch;
		this.semester = semester;
	}
	
	//setter and getter
	public int getStudentId() {
		return studentid;
	}
	public void setStudentId(int studentid) {
		this.studentid = studentid;
	}
	
	public String getName() {
		return name ;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course=course;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch=branch;
	}
	
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester=semester;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
