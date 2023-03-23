package com.example.studentregistration.service.impl;

import com.example.studentregistration.model.Department;
import com.example.studentregistration.model.Student;
import com.example.studentregistration.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department ) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long Id) {
        return departmentRepository.findById(Id).get();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void  deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
