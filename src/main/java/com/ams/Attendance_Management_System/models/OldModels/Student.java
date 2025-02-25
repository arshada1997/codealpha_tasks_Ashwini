package com.ams.Attendance_Management_System.models.OldModels;

import java.util.Date;
import java.util.List;

import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.util.constants.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

//@Entity
@Data
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long student_id;
     
    private int roll_no;

    private String full_name;

    private String email;

    private String password;

    private long mobile_no;

    private Date date_of_birth;

    private String address;

    private String gender;
    @Enumerated(EnumType.STRING)

    private Roles role;
/* 
    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollment;
 */
    /* 
    @ManyToOne
    @JoinColumn(name="course_id",nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name="Sem_id" ,nullable=false)
    private String sem;

    @ManyToOne
    @JoinColumn(name="year_id",nullable = false)
    private Year year;


*/



}
