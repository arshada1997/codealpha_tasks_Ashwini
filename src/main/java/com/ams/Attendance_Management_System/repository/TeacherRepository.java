package com.ams.Attendance_Management_System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
     Optional<Teacher> findByEmail(String email);

     Teacher save(Teacher teacher);
}