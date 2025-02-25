package com.ams.Attendance_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository course_repo;

    @Autowired
    private YearRepository yearRepository;

    @Autowired
    private SemRepository semesterRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Course save(Course course) {
        return course_repo.save(course);
    }

    public List<Course> findAll() {
        return course_repo
                .findAll();
    }

    public List<Course> saveAll(List<Course> course) {
        return course_repo.saveAll(course);

    }

    /*
     * public List<Year> getYearsByCourse(Long course_id) {
     * return yearRepository.findByCourseId(course_id);
     * }
     * 
     * public List<Sem> getSemestersByYear(Long year_id) {
     * return semesterRepository.findByYearId(year_id);
     * }
     * 
     * public List<Subject> getSubjectsBySemester(Long sem_id) {
     * return subjectRepository.findBySemesterId(sem_id);
     * }
     * 
     */}
