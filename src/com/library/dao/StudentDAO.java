package com.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.library.model.Student;


public class StudentDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/library";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "Abhi123";
	
	
	//Method to establish a connection 
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	 
	
	
	//Method to insert a Student
	
	
	public void insertStudent(Student student) throws SQLException{
		
		String sql = "INSERT INTO student(studentid,name,course,branch,semester) values(?,?,?,?,?)";
		
		Connection conn = getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, student.getStudentId());
		pstmt.setString(2,student.getName());
		pstmt.setString(3, student.getCourse());
		pstmt.setString(4,student.getBranch());
		pstmt.setString(5,student.getSemester());
		pstmt.executeUpdate();
		
		System.out.println("student inserted Successfully ");
	}
	
	//Method to retrieve all students
	
	public List<Student> getAllStudents() throws SQLException{
		
		List<Student> students = new ArrayList<>();
		
		String sql = "SELECT * FROM student";
		
		Connection conn = getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			Student student = new Student(rs.getInt("studentid"),rs.getString("name"),rs.getString("course"),rs.getString("branch"),rs.getString("semester"));               
			
			students.add(student);
	}
		return students;
		
	}
	
	// Method to update a student
    public void updateStudent(Student student) throws SQLException {
    	
        String sql = "UPDATE student SET name = ?, course = ?, branch = ?, semester = ? WHERE studentid = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getCourse());
            pstmt.setString(3, student.getBranch());
            pstmt.setString(4, student.getSemester());
            pstmt.setInt(5, student.getStudentId());
           
             int rowsUpdated =  pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student not found");
            }
        }
    }
    
    // Method to delete a student
    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM student WHERE studentid = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, studentId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Student not found");
            }
        }
    }

}
