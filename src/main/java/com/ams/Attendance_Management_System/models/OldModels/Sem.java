package com.ams.Attendance_Management_System.models.OldModels;

import java.util.List;

import com.ams.Attendance_Management_System.models.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sem {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String sem;
   /* 
    @ManyToOne
    @JoinColumn(name = "year_id")
    private Year year;  // Reference to Year entity

     @ManyToMany(mappedBy = "sem")
    private List<Teacher> teachers;  // A course can have multiple teachers
 */
}
