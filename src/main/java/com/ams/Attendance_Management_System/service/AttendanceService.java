package com.ams.Attendance_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Attendance;
import com.ams.Attendance_Management_System.repository.Attendancerepository;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.EnrollmentRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;

@Service
public class AttendanceService {

    @Autowired
    private Attendancerepository attendanceRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private YearRepository yearRepo;

    @Autowired
    private SemRepository semRepo;

    @Autowired
    private SubjectRepository subRepo;

    @Autowired
    private EnrollmentRepository enrollmentRepo;

    public Attendance save(Attendance attendance) {
        // TODO Auto-generated method stub
        System.out.println("erv");

        attendance = attendanceRepo.save(attendance);
        System.out.println("done");

        return attendance;

    }
}
