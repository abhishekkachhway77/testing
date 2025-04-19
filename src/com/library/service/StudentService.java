package com.library.service;

import java.sql.SQLException;

import java.util.List;

import com.library.dao.StudentDAO;
import com.library.model.Student;


public class StudentService {
	private StudentDAO studentDAO;
	
	
	//constructor
	
	public StudentService() {
		this.studentDAO = new StudentDAO();
	}
	
	
	//Business logic to insert student 
	
	public void addStudent(Student student) throws SQLException{
		studentDAO.insertStudent(student);
	}
	
	//Business logic to fetch all students
	
	public List<Student> fetchAllStudent() throws SQLException{
		return studentDAO.getAllStudents();
	}
	
	// Business logic to update a student
    public void upStudent(Student student) throws SQLException {
        studentDAO.updateStudent(student);
    }
    
    // Business logic to delete a student
    public void deleteStudent(int studentId) throws SQLException {
        studentDAO.deleteStudent(studentId);
    }

}

	
	

