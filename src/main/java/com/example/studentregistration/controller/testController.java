package com.example.studentregistration.controller;



import com.example.studentregistration.model.Student;
import com.example.studentregistration.service.impl.DepartmentService;
import com.example.studentregistration.service.impl.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class testController {


    private StudentService studentService;
    private DepartmentService departmentService;

    public testController( StudentService studentService, DepartmentService departmentService) {

        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    // handler method to handle list students and return mode and view

//    < ----------------   list of student    ------>

    @GetMapping("/av")
    public String listStudents( Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("departs", departmentService.getAllDepartment());
        return "test";
    }


//        @GetMapping("/students")
//    public String createStudentForm(Model model) {
//        List<Department> departments= departmentService.getAllDepartment();
//
//        // create student object to hold student form data
//        Student student = new Student();
//        model.addAttribute("students", student);
//        model.addAttribute("departments", departments);
//     //  return "create-student";
//        return "redirect:/av";
//
//    }
    @PostMapping("/student/addNew")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes sms) {
        studentService.saveStudent(student);
        sms.addFlashAttribute("message_save","Student successfully saved");
       // redirAttrs.addFlashAttribute("success", "Everything went just fine.");
        return "redirect:/av";
    }

//    @GetMapping("/students/edit/{id}")
//    public String editStudentForm(@PathVariable Long id, Model model ) {
//        model.addAttribute("student", studentService.getStudentById(id));
//        return "email-sender";
//    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model,RedirectAttributes sms) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);

        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setAddress(student.getAddress());
        existingStudent.setGender(student.getGender());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setDepartment(student.getDepartment());

        // save updated student object
        studentService.updateStudent(existingStudent);
        sms.addFlashAttribute("message_update","Student successfully updated");
        return "redirect:/av";
    }
//
//    // handler method to handle delete student request
//


    @GetMapping("/students/del/{id}")
    public String deleteStudent(@PathVariable Long id,RedirectAttributes sms) {
        studentService.deleteStudentById(id);
        sms.addFlashAttribute("message_delete","Student successfully deleted");
        return "redirect:/av";
    }


//        @GetMapping("/detail/edit/{id}")
//    public String editStudentForm(@PathVariable Long id, Model model ) {
//        model.addAttribute("student", studentService.getStudentById(id));
//        return "email-sender";
//    }







}



