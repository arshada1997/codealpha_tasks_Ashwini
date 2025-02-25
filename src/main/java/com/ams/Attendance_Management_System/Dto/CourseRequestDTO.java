package com.ams.Attendance_Management_System.Dto;
import java.util.List;

import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Year;

import lombok.Data;


@Data
public class CourseRequestDTO {
    private String course_name;

    private List<YearDTO> year;


    // Getters and Setters
    @Data

public static class YearDTO {
      
        private Long year_id;
        private String yearName;
        private List<SemesterDTO> semesters;

        // Getters and Setters
    }
    @Data

  public static class SemesterDTO {
        private String semesterName;
        private List<String> subjects;
    }

}
