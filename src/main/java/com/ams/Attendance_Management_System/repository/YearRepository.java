package com.ams.Attendance_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Year;

@Repository
public interface YearRepository extends JpaRepository<Year, Long> {

  Year save(Year year);
 
}
