package com.ams.Attendance_Management_System.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Fetch all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    // Fetch years based on course ID
    /*
     * @GetMapping("/{course_id}/years")
     * public List<Year> getYearsByCourse(@PathVariable Long course_id) {
     * return courseService.getYearsByCourse(course_id);
     * }
     * 
     * // Fetch semesters based on year ID
     * 
     * @GetMapping("/years/{year_id}/semesters")
     * public List<Sem> getSemestersByYear(@PathVariable Long year_id) {
     * return courseService.getSemestersByYear(year_id);
     * }
     * 
     * // Fetch subjects based on semester ID
     * 
     * @GetMapping("/semesters/{sem_id}/subjects")
     * public List<Subject> getSubjectsBySemester(@PathVariable Long sem_id) {
     * return courseService.getSubjectsBySemester(sem_id);
     * }
     */
    // Fetch years, semesters, and subjects based on the selected course
    /*
     * @GetMapping("/course/{course_id}/details")
     * 
     * @ResponseBody
     * public Map<String, List<?>> getCourseDetails(@PathVariable Long course_id) {
     * Course course = courseService.getCourseDetails(course_id);
     * 
     * Map<String, List<?>> response = new HashMap<>();
     * /* response.put("years", years);
     * response.put("semesters", semesters);
     * response.put("subjects", subjects);
     */
    // return response;
    // }

}
