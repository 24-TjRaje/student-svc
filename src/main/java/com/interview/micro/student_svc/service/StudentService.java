package com.interview.micro.student_svc.service;

import com.interview.micro.student_svc.entity.Student;
import com.interview.micro.student_svc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update student details
    public Student updateStudent(Long id, Student studentDetails) {
        if (studentRepository.existsById(id)) {
            studentDetails.setId(id);
            return studentRepository.save(studentDetails);
        }
        return null;
    }

    // Delete student by ID
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
