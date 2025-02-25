package com.ams.Attendance_Management_System.repository;

import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.Dto.AttendanceReport;
import com.ams.Attendance_Management_System.models.Attendance;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;;

@Repository
public interface Attendancerepository extends JpaRepository<Attendance, Integer> {

  public Attendance save(Attendance attendace);
/* 
  @Query("SELECT new com.ams.Attendance_Management_System.Dto.AttendanceReport(" +
      "a.course.course_id, " +
      "a.year.year_id, " +
      "a.sem.sem_id, " +
      "s.sub_id, " +
      // "a.subject.sub_id, " +
      "a.student.student_id, " +
      "(COUNT(CASE WHEN a.status = 'PRESENT' THEN 1 END) * 100.0) / NULLIF(COUNT(a.attendance_id), 0)) " +
      "FROM Enrollment e " +
      " JOIN e.subjects s " + /* -- Use explicit join on subjects " + */

   /*    "JOIN Attendance a ON e.student.student_id = a.student.student_id " +
      " AND e.course.course_id = a.course.course_id " +
      " AND e.year.year_id = a.year.year_id " +
      " AND e.semester.sem_id = a.sem.sem_id " +
      /*
       * " AND e.subjects.sub_id = a.subject.sub_id "+
       */
    /*   " AND s.sub_id = a.subject.sub_id  " +

      "WHERE a.course.course_id = :course_id " +
      "AND a.year.year_id = :year_id " +
      "AND a.sem.sem_id = :sem_id " +
      /*
       * "AND a.subject.sub_id = :sub_id " +
       *///" AND s.sub_id = :sub_id " +
      /*
       * a.subject.sub_id
       */// "GROUP BY a.course.course_id, a.year.year_id, a.sem.sem_id, s.sub_id, a.student.student_id")*/

       @Query("SELECT new com.ams.Attendance_Management_System.Dto.AttendanceReport(" +
       "a.course, " +   // Fetch Course entity
       "a.year, " +     // Fetch Year entity
       "a.sem, " +      // Fetch Semester entity
       "s, " +          // Fetch Subject entity (from join)
       "a.student, " +  // Fetch Student entity
       "(COUNT(CASE WHEN a.status = 'PRESENT' THEN 1 END) * 100.0) / NULLIF(COUNT(a.attendance_id), 0)) " +
       "FROM Enrollment e " +
       "JOIN e.subjects s " + 
       "JOIN Attendance a ON e.student.student_id = a.student.student_id " +
       " AND e.course.course_id = a.course.course_id " +
       " AND e.year.year_id = a.year.year_id " +
       " AND e.semester.sem_id = a.sem.sem_id " +
       " AND s.sub_id = a.subject.sub_id " +
       "WHERE a.course.course_id = :course_id " +
       "AND a.year.year_id = :year_id " +
       "AND a.sem.sem_id = :sem_id " +
       "AND s.sub_id = :sub_id " +
       "GROUP BY a.course, a.year, a.sem, s, a.student")
  List<AttendanceReport> getAttendanceReportByCourseSubjectSemesterYear(Long course_id, Long year_id,
      Long sem_id, Long sub_id);

}