package com.ams.Attendance_Management_System.models.OldModels;

import java.util.List;

import com.ams.Attendance_Management_System.models.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Entity
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long sub_id;

    private String sub_name;
   /*  
    @ManyToMany(mappedBy = "subject")
    private List<Course> course;
    
    @ManyToMany(mappedBy = "subject")
    private List<Teacher> teachers;  // A course can have multiple teachers
    */ 
}
