package com.ams.Attendance_Management_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

/*     List<Subject> findByEnrollmentId(Long id);
 */
}
