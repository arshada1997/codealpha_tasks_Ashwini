package com.ams.Attendance_Management_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ams.Attendance_Management_System") // Ensure package scanning

public class AttendanceManagementSystemApplication extends SpringBootServletInitializer{

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AttendanceManagementSystemApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
	}
  

}
