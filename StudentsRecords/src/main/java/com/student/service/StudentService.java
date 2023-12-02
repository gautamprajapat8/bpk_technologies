package com.student.service;

import java.util.List;
import java.util.Optional;
import com.student.exception.StudentException;
import com.student.model.Student;

public interface StudentService {

    Student addStudent(Student student) throws StudentException;
    Student updateStudent(Integer id, Student updatedStudent) throws StudentException;
    void deleteStudent(Integer id) throws StudentException;
    List<Student> getAllStudents() throws StudentException;
    Optional<Student> getStudentById(Integer id) throws StudentException;
}
