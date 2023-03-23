package com.example.studentregistration.controller;



import com.example.studentregistration.model.Student;
import org.springframework.ui.Model;
import com.example.studentregistration.model.Department;
import com.example.studentregistration.service.impl.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/dev")
    public String getAll(Model model){

        model.addAttribute("departments", departmentService.getAllDepartment());
        return "departs";
    }


    @GetMapping("/depart/{id}")
    public String deleteDepart(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/dev";
    }
    @GetMapping("/depart/new")
    public String createDepartment(Model model) {

        // create student object to hold student form data
        Department department=new Department();
        model.addAttribute("Department", department);

        return "create-department";

    }

    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/dev";
    }

}
