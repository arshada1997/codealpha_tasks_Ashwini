package com.ams.Attendance_Management_System.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

/*     Student findById(Student student_id);
 */
    // Student
    // List<Student> saveAll(List<Student> students);
}