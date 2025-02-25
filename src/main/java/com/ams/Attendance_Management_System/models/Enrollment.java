package com.ams.Attendance_Management_System.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enrollment", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "student_id", "course_id" })
})
public class Enrollment {

    public Enrollment(Student student, Course course, Year year, Sem sem, List<Subject> subject) {

        this.student = student;
        this.course = course;
        this.year = year;
        this.semester = sem;
        this.subjects = subject;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "student_id", unique = true) // ✅ Unique to prevent duplicate enrollments
    private Student student;

    @ManyToOne
    @ToString.Exclude

    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @ManyToOne
    @ToString.Exclude

    @JoinColumn(name = "sem_id", referencedColumnName = "sem_id")
    private Sem semester;

    @ManyToOne
    @ToString.Exclude

    @JoinColumn(name = "year_id", referencedColumnName = "year_id")
    private Year year; // Reference to Year entity
    @ManyToMany
    @JoinTable(name = "enrollment_subject", joinColumns = @JoinColumn(name = "enrollment_id"), inverseJoinColumns = @JoinColumn(name = "sub_id"))
    @ToString.Exclude
    @JsonBackReference // Prevents infinite loop

    private List<Subject> subjects; // Correct! This maps multiple subjects.

    @Column(name = "enrollment_date")
    /* nullable = false) */
    private LocalDate enrollment_date;
}
