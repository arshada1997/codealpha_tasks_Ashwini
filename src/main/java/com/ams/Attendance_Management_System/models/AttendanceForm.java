package com.ams.Attendance_Management_System.models;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class AttendanceForm {

      
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
  

    private String course;
     
    private String sem;

    private String year;

    private String subject;
 
    private List<Attendance> attendances;

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
