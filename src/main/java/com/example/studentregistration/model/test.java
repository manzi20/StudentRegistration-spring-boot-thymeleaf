package com.example.studentregistration.model;

import com.example.studentregistration.constant.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Table(name = "testing_Table")
@Entity

public class test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{validation.firstname.NotEmpty}")
    @Column(name = "fname")
//    @Size(min = 2, max = 10, message = "{validation.firstname.Size}")
    private String FirstName;

    @NotEmpty(message = "{validation.lastname.NotEmpty}")
    @NotNull
    @Column(name = "lname")
//    @Size(min = 2, max = 10, message = "{validation.lastname.Size}")
    private String LastName;

    @NotEmpty(message = "{validation.gender.NotEmpty}")
    @Column(name = "gender")
    private String Gender;
//    @NotEmpty(message = "{validation.phonenumber.NotEmpty}")


    @Column(name = "phone")
    private String PhoneNumber;

    @NotEmpty(message = "{validation.address.NotEmpty}")
    @NotNull
    @Column(name = "address")
    private String Address;

    private Subject subjects;

    public test(Long id, String firstName, String lastName, String gender, String phoneNumber, String address) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        PhoneNumber = phoneNumber;
        Address = address;
    }


}
