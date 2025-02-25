package com.ams.Attendance_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.repository.SemRepository;

@Service
public class SemService {

    @Autowired
    private SemRepository sem_repo;

    public Sem save(Sem sem) {
        return sem_repo.save(sem);
    }

    public List<Sem> saveAll(List<Sem> sem) {
        return sem_repo.saveAll(sem);

    }

}
