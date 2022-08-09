package com.example.training.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.example.training.entity.Student;
import com.example.training.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		if(ObjectUtils.isEmpty(student)) {
			return null;
		}else {
			return studentRepository.save(student);
		}
	}
	
	public List<Student> getAllStudents() throws Exception{
		List<Student> studentsList = studentRepository.findAll();
		
		if (studentsList.isEmpty()) {
			throw new Exception("Student list is empty!");
		}else {
		return studentsList;
		}
	}
	
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}
	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
}
