package com.student.repository;

//import javax.transaction.Transactional;

//import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.student.model.Student;

import jakarta.transaction.Transactional;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}


