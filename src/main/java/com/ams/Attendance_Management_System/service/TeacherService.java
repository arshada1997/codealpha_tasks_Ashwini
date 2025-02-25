package com.ams.Attendance_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Teacher;
import com.ams.Attendance_Management_System.models.TeacherSubject;
import com.ams.Attendance_Management_System.models.Year;
import com.ams.Attendance_Management_System.repository.TeacherRepository;
import com.ams.Attendance_Management_System.repository.TeacherSubjectRepository;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherSubjectRepository teacherSubjectRepository;

    public Teacher save(Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    public TeacherSubject save(TeacherSubject teacherSubject) {
        return teacherSubjectRepository.save(teacherSubject);
    }

    /*
     * public List<Subject> getSubjectsForTeacher(Long teacher_id, Long course_id,
     * Long year_id, Long sem_id) {
     * return
     * teacherSubjectRepository.findSubjectsByTeacherId(teacher_id,course_id,year_id
     * ,sem_id);
     * }
     */

    public List<Subject> getSubjectsForTeacher(Long teacher_id) {
        return teacherSubjectRepository.findSubjectsByTeacherId(teacher_id);
    }

    public List<Course> getCourseForTeacher(Long teacher_id) {
        return teacherSubjectRepository.findCourseByTeacherId(teacher_id);
    }

    public List<Year> getYearForTeacher(Long teacher_id) {
        return teacherSubjectRepository.findYearByTeacherId(teacher_id);
    }

    public List<Sem> getSemesterForTeacher(Long teacher_id) {
        return teacherSubjectRepository.findSemesterByTeacherId(teacher_id);
    }

}
