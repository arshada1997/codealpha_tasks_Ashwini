package com.ams.Attendance_Management_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.SelectedCourseDetails;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Year;

@Repository
public interface SelectedCourseDetailsRepository extends JpaRepository<SelectedCourseDetails, Long> {
  
  @Query("SELECT s.subjects FROM SelectedCourseDetails s WHERE s.course.course_id = :course_id AND s.year.year_id = :year_id AND s.sem.sem_id=:sem_id")
  List<Subject> findSubjectsByCourseYearSemester(@Param("course_id") Long course_id,
      @Param("year_id") Long year_id,
      @Param("sem_id") Long sem_id);

  @Query("SELECT DISTINCT s.year FROM SelectedCourseDetails s WHERE s.course.course_id = :course_id")

  public List<Year> findDistinctYearsByCourseId(Long course_id);

  @Query("SELECT DISTINCT s.sem FROM SelectedCourseDetails s WHERE s.course.course_id = :course_id")
  public List<Sem> findDistinctSemestersByCourseId(Long course_id);

  @Query("SELECT DISTINCT s.subjects FROM SelectedCourseDetails s WHERE s.course.course_id = :course_id")

  List<Subject> findSubjectsByCourseYearSemester(Long course_id);

}
