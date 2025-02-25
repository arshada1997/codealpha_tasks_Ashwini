package com.ams.Attendance_Management_System.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long year_id;

    private String year;

    @OneToMany(mappedBy = "year")
    private List<SelectedCourseDetails> selections;

    @OneToMany(mappedBy = "year")
    @JsonManagedReference //  Prevents infinite recursion

    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "year")
    private List<TeacherSubject> teacherSubjects; //  Relation to TeacherSubject

}