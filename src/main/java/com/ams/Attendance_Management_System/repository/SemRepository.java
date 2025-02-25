package com.ams.Attendance_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Attendance_Management_System.models.Sem;

@Repository
public interface SemRepository extends JpaRepository<Sem, Long> {

  /*
   * @Query("SELECT s FROM Sem s WHERE s.year.year_id = :year_id")
   * 
   * List<Sem> findByYearId(Long year_id);
   */

}
