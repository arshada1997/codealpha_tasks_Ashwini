package com.ams.Attendance_Management_System.models.OldModels;

import java.util.ArrayList;
import java.util.List;

import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.models.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



public class Course {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long course_id;

    private String course_name;


   // @OneToMany(mappedBy = "course",  orphanRemoval = true)
  //  private List<Year> years


   /*   @ManyToMany(mappedBy = "course")
     @ToString.Exclude
    private List<Teacher> teachers;  // A course can have multiple teachers
 */
/* 
    @ManyToMany
    @ToString.Exclude // Prevent recursion

    @JoinTable(
        name = "course_subject",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subject; */

/*     @OneToMany(mappedBy = "course")
   @ToString.Exclude // Prevent recursion

    private List<Enrollment> enrollments;

 */
}
