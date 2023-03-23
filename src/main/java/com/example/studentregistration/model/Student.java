package com.example.studentregistration.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="StudentReg")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(min = 2, max = 10, message = "{validation.firstname.Size}")
    private String FirstName;



//    @Size(min = 2, max = 10, message = "{validation.lastname.Size}")
    private String LastName;


    private String Gender;
//    @NotEmpty(message = "{validation.phonenumber.NotEmpty}")

    private String PhoneNumber;


    private String Address;

//    private List<String> subjects;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
