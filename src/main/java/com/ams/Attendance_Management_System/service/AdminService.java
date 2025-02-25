package com.ams.Attendance_Management_System.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

}
