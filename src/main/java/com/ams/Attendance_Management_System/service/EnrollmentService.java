package com.ams.Attendance_Management_System.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollment_repo;

    public Enrollment save(Enrollment enrollment) {
        return enrollment_repo.save(enrollment);
    }

    public Optional<Enrollment> findById(Long course_id) {
        return enrollment_repo.findById(course_id);
    }
    /*
     * public List<Year> findDistinctYearsByCourseId(Long course_id) {
     * return enrollment_repo.findDistinctYearsByCourseId(course_id);
     * }
     * 
     * public List<Subject> findDistinctSubjectsByCourseId(Long course_id) {
     * return enrollment_repo.findDistinctSubjectsByCourseId(course_id);
     * }
     * 
     * public List<Sem> findDistinctSemestersByCourseId(Long course_id) {
     * return enrollment_repo.findDistinctSemestersByCourseId(course_id);
     * }
     */

    public Enrollment getEnrollmentsById(Long id) {

        return enrollment_repo.getEnrollmentsById(id);
    }

    public void updateEnrollment(Enrollment enrollment) {
      
        enrollment_repo.save(enrollment);
        System.out.println("Updated Enrollment"+enrollment);
      //  throw new UnsupportedOperationException("Unimplemented method 'updateEnrollment'");
    }
}
