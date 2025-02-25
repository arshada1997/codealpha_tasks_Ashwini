package com.ams.Attendance_Management_System.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.SelectedCourseDetails;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.SelectedCourseDetailsRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;

@Service
public class SelectedCourseDetailsService {
    @Autowired
    private SelectedCourseDetailsRepository repository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private YearRepository yearRepository;

    @Autowired
    private SemRepository semesterRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public void save(SelectedCourseDetails selectedCourse) {

        repository.save(selectedCourse);

    }

    @Autowired
    private SelectedCourseDetailsRepository selectedCourseDetailsRepository;

    /*
     * public List<Year> getYearsByCourse(Long course_id) {
     * return selectedCourseDetailsRepository.findYearsByCourse(course_id);
     * }
     */
    /*
     * public List<Sem> getSemestersByCourseAndYear(Long year_id) {
     * return selectedCourseDetailsRepository.findSemestersByCourseAndYear(year_id);
     * }
     */

    public List<Subject> getSubjectsByCourseYearSemester(Long course_id, Long year_id, Long sem_id) {
        return selectedCourseDetailsRepository.findSubjectsByCourseYearSemester(course_id, year_id, sem_id);
    }

    public Optional<Admin> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}