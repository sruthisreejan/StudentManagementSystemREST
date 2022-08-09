package com.example.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.training.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
