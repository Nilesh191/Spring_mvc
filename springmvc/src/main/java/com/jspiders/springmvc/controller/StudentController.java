package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.dto.StudentDTO;
import com.jspiders.springmvc.service.StudentService;
@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@GetMapping("/addStudent")
	private String addStudent() {
		return "AddStudentForm";
	}
	@PostMapping("/addStudent")
	private String addStudent(@RequestParam String name,@RequestParam String email,@RequestParam String userName,
			@RequestParam String standard,@RequestParam String password ) {
		service.addStudent(name,email,userName,password,standard);
		return "AddStudentForm";
	}
	
	@GetMapping("home")
	private String login() {
		return "LoginPage";
	}
	@PostMapping("/home")
	private String login(@RequestParam String userName,@RequestParam String password,ModelMap map) {
		StudentDTO student=service.login(userName,password);
		if (student !=null) {
			map.addAttribute("student",student);
			return "HomePage";
		}
		map.addAttribute("msg","invalid username and password");
		return "LoginPage";
	}
	@GetMapping("/logout")
	private String logout(ModelMap map) {
		map.addAttribute("msg", "Successfully logged out");
		return "LoginPage";
	}
	@GetMapping("/removeStudent")
	private String removeStudent(ModelMap map) {
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "RemoveStudent";
	}

	@PostMapping("/removeStudent")
	private String removeStudent1(@RequestParam int id, ModelMap map) {
		StudentDTO student = service.removeStudent(id);
		if (student != null) {
			map.addAttribute("msg", "Student removed from database");
			List<StudentDTO> students = service.viewAllStudents();
			map.addAttribute("students", students);
			return "RemoveStudent";
		}
		map.addAttribute("msg", "Invalid student id entered");
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "RemoveStudent";
	}
	
	@GetMapping("/updateStudent")
	private String updateStudent(ModelMap map) {
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdateStudent";
	}
	@PostMapping("/updateStudent")
	private String updateStudent1(@RequestParam int id, ModelMap map) {
		StudentDTO student = service.searchStudent(id);
		if (student != null) {
			map.addAttribute("student", student);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Invalid student id entered");
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdateStudent";
	}
	@PostMapping("/updateStudentData")
	private String updateStudent2(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam String userName, @RequestParam String password, ModelMap map) {
		StudentDTO student = service.searchStudent(id);
		if (student != null) {
			service.updateStudent(id, name, email, userName, password);
			map.addAttribute("msg", "Student updated successfully");
			List<StudentDTO> students = service.viewAllStudents();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "Student not found");
		List<StudentDTO> students = service.viewAllStudents();
		map.addAttribute("students", students);
		return "UpdateStudent";
	}

}
