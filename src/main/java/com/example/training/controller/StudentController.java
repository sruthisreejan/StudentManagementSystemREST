package com.example.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.entity.Student;
import com.example.training.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents(){
		try {
			return studentService.getAllStudents();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		studentService.deleteStudentById(id);
	}
	
	@GetMapping("/get/{id}")
	public Student getStudentById(@PathVariable int id){
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/save")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
}
