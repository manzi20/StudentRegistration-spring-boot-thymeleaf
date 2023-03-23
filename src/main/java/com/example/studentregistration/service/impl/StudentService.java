package com.example.studentregistration.service.impl;

import com.example.studentregistration.model.Student;
import com.example.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);



    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
