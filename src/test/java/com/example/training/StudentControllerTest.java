package com.example.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.training.controller.StudentController;
import com.example.training.entity.Student;
import com.example.training.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	
	@InjectMocks
	private StudentController studentController;
	
	@Mock
	StudentService studentService;
	
	@Test
	public void saveStudentControllerTest() {
		Student student=new Student(1,"test",25,"test@gmail.com");
		Mockito.when(studentService.saveStudent(student)).thenReturn(student);
		assertEquals(student, studentController.saveStudent(student));
	}
	
	@Test
	public void updateStudentControllerTest() {
		Student student=new Student(1,"test",25,"test@gmail.com");
		Mockito.when(studentService.updateStudent(student)).thenReturn(student);
		assertEquals(student, studentController.updateStudent(student));
	}
	
	@Test
	public void getStudentByIdControllerTest() {
		Student student=new Student(1,"test",25,"test@gmail.com");
		Mockito.when(studentService.getStudentById(1)).thenReturn(student);
		assertEquals(student, studentController.getStudentById(1));
	}
	
	@Test
	public void getAllStudentsControllerTest() throws Exception {
		List<Student> studentList = Stream.of(new Student(1,"test1",25,"test1@gmail.com"),
				new Student(2,"test2",25,"test2@gmail.com"),
				new Student(2,"test93",25,"test3@gmail.com"))
				.collect(Collectors.toList());
		Mockito.when(studentService.getAllStudents()).thenReturn(studentList);
		assertEquals(3, studentController.getAllStudents().size());
	}
	
	@Test
	public void deleteStudentControllerTest() {
		studentController.deleteById(1);
	    verify(studentService,times(1)).deleteStudentById(1);
	}

}
