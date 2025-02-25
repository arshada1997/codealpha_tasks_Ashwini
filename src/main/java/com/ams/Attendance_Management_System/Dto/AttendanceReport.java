package com.ams.Attendance_Management_System.Dto;

import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Student;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Year;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AttendanceReport {
/* Change in DTO ,query ,report table.html* /
    /*
     * Old Working DTO private Long id;
     * private Long course_id;
     * private Long year_id;
     * private Long sem_id;
     * 
     * private Long sub_id;
     * 
     * private Long student_id;
     * 
     * private double attendancePercentage;
     * 
     * // Constructor that matches the parameters from the query
     * public AttendanceReport(Long course_id, Long year_id, Long sem_id, Long
     * sub_id, Long student_id,
     * Double attendancePercentage) {
     * this.course_id = course_id;
     * this.year_id = year_id;
     * this.sem_id = sem_id;
     * this.sub_id = sub_id;
     * this.student_id = student_id;
     * this.attendancePercentage = attendancePercentage;
     * }
     * 
     * // Getters and Setters
     */

    private Course course;

    private Year year;

    private Sem sem;

    private Subject subject;

    private Student student;

    private double attendancePercentage;

    // Constructor that matches the parameters from the query
     public AttendanceReport(Course course, Year year, Sem sem, Subject
     subject, Student student,Double attendancePercentage) {
     this.course = course;
     this.year = year;
     this.sem = sem;
     this.subject = subject;
     this.student = student;
     this.attendancePercentage = attendancePercentage;}
    

}
