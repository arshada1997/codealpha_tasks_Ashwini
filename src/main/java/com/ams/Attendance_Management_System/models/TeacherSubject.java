package com.ams.Attendance_Management_System.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "teacherSubjects")
public class TeacherSubject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "teacher_id")
  @ToString.Exclude
  @JsonManagedReference //  Prevents infinite recursion

  private Teacher teacher;

  @ManyToOne
  @JoinColumn(name = "course_id")
  @ToString.Exclude
  @JsonManagedReference //  Prevents infinite recursion

  private Course course;

  @ManyToOne

  @JoinColumn(name = "year_id")
  @ToString.Exclude
  @JsonManagedReference //  Prevents infinite recursion

  private Year year;

  @ManyToOne
  @JoinColumn(name = "sem_id")
  @ToString.Exclude
  @JsonManagedReference //  Prevents infinite recursion

  private Sem semester;

  @ManyToMany //  Force fetching subjects
  @JoinTable(name = "selected_teacher_subjects", //  Join table for subjects
      joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "sub_id"))
  @ToString.Exclude
  @JsonManagedReference // Prevents infinite recursion

  private List<Subject> subject;
}
