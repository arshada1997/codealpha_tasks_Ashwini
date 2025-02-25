package com.ams.Attendance_Management_System.repository;

import java.time.Year;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  // @Query("SELECT c FROM Course c JOIN FETCH c.years y JOIN FETCH y.semesters s
  // JOIN FETCH s.subjects WHERE c.course_id = :course_id")
  // Course findCourseWithDetails(@Param("course_id") Long course_id);
}
