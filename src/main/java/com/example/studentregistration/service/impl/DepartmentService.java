package com.example.studentregistration.service.impl;

import com.example.studentregistration.model.Department;
import com.example.studentregistration.model.Student;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartment();

    Department saveDepartment(Department department );

    Department getDepartmentById(Long Id);

    Department updateDepartment(Department department);

    void deleteDepartmentById(Long id);

}
