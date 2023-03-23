package com.example.studentregistration.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Table
@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String DepartmentName;

    @OneToMany(mappedBy = "department")
    private Set<Student> departmentStudents;



}
