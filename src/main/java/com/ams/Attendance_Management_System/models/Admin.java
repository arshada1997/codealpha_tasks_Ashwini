package com.ams.Attendance_Management_System.models;

import java.time.LocalDate;
import com.ams.Attendance_Management_System.util.constants.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_no")
    private long mobile_no;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;
}
