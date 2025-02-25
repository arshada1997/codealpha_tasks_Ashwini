package com.ams.Attendance_Management_System.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "sem")

public class Sem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sem_id") // Ensure this matches your database column

  private Long sem_id;

  private String sem;

  @OneToMany(mappedBy = "sem")
  private List<SelectedCourseDetails> selections;
  @OneToMany(mappedBy = "semester")
  @JsonManagedReference //  Prevents infinite recursion

  private List<Enrollment> enrollments;

  @OneToMany(mappedBy = "semester")
  private List<TeacherSubject> teacherSubjects; // Relation to TeacherSubject

}
