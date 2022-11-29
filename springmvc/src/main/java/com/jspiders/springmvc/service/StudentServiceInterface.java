package com.jspiders.springmvc.service;

import java.util.List;

import com.jspiders.springmvc.dto.StudentDTO;

public interface StudentServiceInterface {
	void addStudent(String name,String email,String userName,String password,String standard);
	StudentDTO login(String userName, String password);
	StudentDTO removeStudent(int id);
	List<StudentDTO> viewAllStudents();
	String updateStudent(int id, String name, String email, String userName, String password);
}
