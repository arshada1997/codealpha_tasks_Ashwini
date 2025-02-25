package com.ams.Attendance_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subject_repo;

    public Subject save(Subject subject) {
        return subject_repo.save(subject);
    }

    public List<Subject> saveAll(List<Subject> subjects) {
        return subject_repo.saveAll(subjects);

    }
    /*
     * public List<Subject> getSubjectsByCourseAndSemester(Long courseId, Long
     * semesterId) {
     * return subject_repo.findSubjectsByCourseAndSemester(courseId, semesterId);
     * }
     */}
