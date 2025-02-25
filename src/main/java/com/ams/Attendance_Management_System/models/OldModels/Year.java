package com.ams.Attendance_Management_System.models.OldModels;

import java.util.List;

import com.ams.Attendance_Management_System.models.Enrollment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

//@Data
//@Entity
public class Year {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long year_id;

    private String year;
/* 
    @OneToMany(mappedBy = "year")
    private List<Enrollment> enrollments; */
/* 
    @OneToMany(mappedBy = "year",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sem> sem;
 */}
