package com.ams.Attendance_Management_System.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "subject")

public class Subject {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "sub_id")

   private long sub_id;

   @Column(name = "sub_name")

   private String sub_name;

   @ManyToMany(mappedBy = "subjects")
   @ToString.Exclude
   @JsonIgnore // Prevents recursion

   private List<Enrollment> enrollments;

   @ManyToMany(mappedBy = "subjects")
   @JsonIgnore // Prevents recursion
   @ToString.Exclude

   private List<SelectedCourseDetails> selectedCourseDetails;

   @ManyToMany(mappedBy = "subject")
   @ToString.Exclude
   @JsonManagedReference // Prevents infinite recursion

   // Back reference to TeacherSubject
   private List<TeacherSubject> teacherSubjects;
}
