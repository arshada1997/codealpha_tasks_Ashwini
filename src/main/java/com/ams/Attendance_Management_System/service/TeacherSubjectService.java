package com.ams.Attendance_Management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.repository.TeacherSubjectRepository;

@Service
public class TeacherSubjectService {

    @Autowired
    private TeacherSubjectRepository teacherSubject_repo;

    /*
     * public TeacherSubject save(TeacherSubject teacherSubject)
     * {
     * return teacherSubject_repo.save(teacherSubject);
     * }
     */
}