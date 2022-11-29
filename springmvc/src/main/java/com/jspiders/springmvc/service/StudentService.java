package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.dao.StudentDAO;
import com.jspiders.springmvc.dto.StudentDTO;
@Service
public class StudentService implements StudentServiceInterface{
	@Autowired
	private StudentDAO dao;
	
	@Override
	public void addStudent(String name,String email,String userName,String password,String standard) {
		if (name!=null && email!=null &&userName!=null && password !=null &&standard!=null) {
			dao.addStudent(name, email, userName, password,standard);
		}
	}
	@Override
	public StudentDTO login(String userName, String password) {
		if (userName != null && password != null) {
			StudentDTO student = dao.login(userName, password);
			if (student != null) {
				return student;
			}
		}
		return null;
	}
	@Override
	public List<StudentDTO> viewAllStudents() {
		List<StudentDTO> students = dao.viewAllStudents();
		return students;
	}

	@Override
	public StudentDTO removeStudent(int id) {
		if (id >= 0) {
			StudentDTO student = dao.removeStudent(id);
			return student;
		}
		return null;

	}
	@Override
	public String updateStudent(int id, String name, String email, String userName, String password) {
		if(id>0) {
			StudentDTO student=dao.updateStudent(id, name, email, userName, password);
		}
		return null;
		
	}
	public StudentDTO searchStudent(int id) {
		if(id>0) {
			StudentDTO student=dao.searchStudent(id);
		}
		return null;
	}
	
}
