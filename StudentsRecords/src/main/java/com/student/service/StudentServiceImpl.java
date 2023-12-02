package com.student.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.exception.StudentException;
import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() throws StudentException 
    {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new StudentException("Error fetching all students", e);
        }
    }

    @Override
    public Optional<Student> getStudentById(Integer id) throws StudentException {
        try {
            return studentRepository.findById(id);
        } catch (Exception e) {
            throw new StudentException("Error fetching student with id " + id, e);
        }
    }

    @Override
    public Student addStudent(Student student) throws StudentException {
        try {
            validateStudentData(student);
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new StudentException("Error adding student", e);
        }
    }

    @Override
    public Student updateStudent(Integer id, Student updatedStudent) throws StudentException {
        try {
            Optional<Student> existingStudent = studentRepository.findById(id);

            if (existingStudent.isPresent()) {
                Student student = existingStudent.get();
                validateStudentData(updatedStudent);

                student.setName(updatedStudent.getName());
                student.setMajor(updatedStudent.getMajor());
                student.setEnrollmentDate(updatedStudent.getEnrollmentDate());

                return studentRepository.save(student);
            } else {
                throw new StudentException("Student with id " + id + " not found");
            }
        } catch (Exception e) {
            throw new StudentException("Error updating student", e);
        }
    }

    @Override
    public void deleteStudent(Integer id) throws StudentException {
        try {
            if (studentRepository.existsById(id)) {
                studentRepository.deleteById(id);
            } else {
                throw new StudentException("Student with id " + id + " not found");
            }
        } catch (Exception e) {
            throw new StudentException("Error deleting student", e);
        }
    }

    private void validateStudentData(Student student) throws StudentException {
        // Add validation logic for student data here
        if (student.getName() == null || student.getName().isEmpty()) {
            throw new StudentException("Student name cannot be empty");
        }

        if (student.getMajor() == null || student.getMajor().isEmpty()) {
            throw new StudentException("Major cannot be empty");
        }

        if (student.getEnrollmentDate() == null || student.getEnrollmentDate().isEmpty()) {
            throw new StudentException("Enrollment date cannot be empty");
        }

        
    }

}
