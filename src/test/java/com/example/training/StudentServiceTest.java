package com.example.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.training.entity.Student;
import com.example.training.repo.StudentRepository;
import com.example.training.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	
	@InjectMocks	
	private StudentService service;
	
	@Mock
	StudentRepository repo;
	
    @Test
	public void getStudentByIdTest1() {
    	Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(new Student(1,"test",25,"test@gmail.com")));
    	assertEquals(1, service.getStudentById(1).getId());
    }
    
    @Test
	public void getStudentByIdTest2() {
    	Mockito.when(repo.findById(Mockito.anyInt())).thenReturn(Optional.of(new Student(1,"test",25,"test@gmail.com")));
    	assertEquals("test", service.getStudentById(1).getName());
    }
	
	@Test
	public void getAllStudentsTest() throws Exception {
		Mockito.when(repo.findAll()).thenReturn(Stream.of(new Student(1,"test1",25,"test1@gmail.com"),
				new Student(2,"test2",25,"test2@gmail.com"),
				new Student(2,"test93",25,"test3@gmail.com"))
				.collect(Collectors.toList()));
    	assertEquals(3,service.getAllStudents().size());
    }
	
	@Test
	public void saveStudentTest() {
		Student student = new Student(1,"test",25,"test@gmail.com");
		Mockito.when(repo.save(student)).thenReturn(student);
		assertEquals(student, service.saveStudent(student));
	}
	
	@Test
	public void updateStudentTest() {
		Student student = new Student(1,"test1",25,"test@gmail.com");
		Mockito.when(repo.save(student)).thenReturn(student);
		assertEquals(student, service.updateStudent(student));
	}
	
	@Test
	public void deleteStudentTest(){
		service.deleteStudentById(1);
	    verify(repo,times(1)).deleteById(1);
	}
}
