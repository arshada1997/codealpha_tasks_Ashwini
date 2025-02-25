package com.ams.Attendance_Management_System.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ams.Attendance_Management_System.models.Year;
import com.ams.Attendance_Management_System.repository.YearRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class YearService {

    @PersistenceContext
    private EntityManager entityManager; // Inject EntityManager

    @Autowired
    private YearRepository year_repo;

    public Year save(Year year) {
        return year_repo.save(year);
    }

    public List<Year> saveAll(List<Year> year) {
        return year_repo.saveAll(year);

    }
}
