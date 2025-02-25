package com.ams.Attendance_Management_System.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long course_id;

   private String course_name;

   @OneToMany(mappedBy = "course")
   private List<SelectedCourseDetails> selections; // Course-Year-Semester mapping

   @OneToMany(mappedBy = "course")
   @JsonManagedReference //  Prevents infinite recursion

   private List<Enrollment> enrollments;

   @OneToMany(mappedBy = "course")
   private List<TeacherSubject> teacherSubjects; //  Relation to TeacherSubject
}
