package com.ams.Attendance_Management_System.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "attendance")

public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "attendance_id")
  private int attendance_id;

  @ManyToOne
  @JoinColumn(name = "course_id", referencedColumnName = "course_id")
  private Course course;

  @ManyToOne
  @JoinColumn(name = "year_id", referencedColumnName = "year_id")

  private Year year;

  @ManyToOne
  @JoinColumn(name = "sem_id", referencedColumnName = "sem_id")

  private Sem sem;
  @ManyToOne
  @JoinColumn(name = "subject_id", referencedColumnName = "sub_id")

  private Subject subject;
  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

  @Column(name = "datetime")
  private LocalDateTime DateTime; // Stores both date and time
  @Column(name = "status") // Present or Absent
  private String status;

  // Getters and Setters
}
