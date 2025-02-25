package com.ams.Attendance_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Student;
import com.ams.Attendance_Management_System.models.Year;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
  boolean existsByStudent(Optional<Student> student);

  Enrollment save(Student student);

  @Query("SELECT DISTINCT e.year FROM Enrollment e WHERE e.course.course_id = :course_id")
  List<Year> findDistinctYearsByCourseId(Long course_id);

  @Query("SELECT DISTINCT e.semester FROM Enrollment e WHERE e.course.course_id = :course_id")
  List<Sem> findDistinctSemestersByCourseId(Long course_id);

  Optional<Enrollment> findById(Long student_id);

  @Query("SELECT e FROM Enrollment e JOIN FETCH e.subjects")
List<Enrollment> findAll();

  Enrollment getEnrollmentsById(Long id);
/* 
  @Query("SELECT e.student FROM Enrollment e where e.id=:id")

  Student findStudentByEnrollmentId(Long id);
 */}
