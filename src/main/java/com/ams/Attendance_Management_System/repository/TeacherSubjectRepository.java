package com.ams.Attendance_Management_System.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ams.Attendance_Management_System.models.*;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, Long> {
  // @Query("SELECT DISTINCT ts.subject FROM TeacherSubject ts WHERE ts.teacher.id
  // = :teacher_id AND ts.course_id=:course_id AND ts.year.year_id=:year_id AND
  // ts.semester.sem_id=:sem_id")
  @Query("SELECT DISTINCT ts.subject FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id ")
  List<Subject> findSubjectsByTeacherId(Long teacher_id);

  // List<Subject> findSubjectsByTeacherId(Long teacher_id, Long course_id, Long
  // year_id, Long sem_id);
  // @Query(SELECT e)
  TeacherSubject save(TeacherSubject teacherSubject);

  @Query("SELECT DISTINCT ts FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id")
  // @Query("SELECT ts FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id")
  List<TeacherSubject> findAllById(Long teacher_id);

  @Query("SELECT DISTINCT ts.course FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id ")
  List<Course> findCourseByTeacherId(Long teacher_id);

  @Query("SELECT DISTINCT ts.year FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id ")

  List<Year> findYearByTeacherId(Long teacher_id);

  @Query("SELECT DISTINCT ts.semester FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id ")

  List<Sem> findSemesterByTeacherId(Long teacher_id);

  /*
   * @Query("SELECT ts.course FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id "
   * )
   * 
   * List<Year> findAllById(Long teacher_id);
   * 
   * @Query("SELECT ts.course FROM TeacherSubject ts WHERE ts.teacher.id = :teacher_id"
   * )
   * 
   * List<Sem> findAllById(Long teacher_id);
   */
  // Optional<TeacherSubject> findAllById(Long teacher_id, Long course_id, Long
  // year_id, Long sem_id);
}
