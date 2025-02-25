package com.ams.Attendance_Management_System.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Teacher;
import com.ams.Attendance_Management_System.models.TeacherSubject;
import com.ams.Attendance_Management_System.models.Year;
import com.ams.Attendance_Management_System.Dto.AttendanceReport;
import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.Attendance;
import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.repository.Attendancerepository;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.EnrollmentRepository;
import com.ams.Attendance_Management_System.repository.SelectedCourseDetailsRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.StudentRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.TeacherRepository;
import com.ams.Attendance_Management_System.repository.TeacherSubjectRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;
import com.ams.Attendance_Management_System.service.AttendanceService;
import com.ams.Attendance_Management_System.service.CourseService;
import com.ams.Attendance_Management_System.service.EnrollmentService;
import com.ams.Attendance_Management_System.service.SelectedCourseDetailsService;
import com.ams.Attendance_Management_System.service.TeacherService;
import com.ams.Attendance_Management_System.util.constants.Roles;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

  @Autowired
  private AttendanceService attendanceService;

  @Autowired
  private TeacherService teacherService;

  @Autowired
  private CourseService courseService;
  @Autowired
  private EnrollmentService enrollmentService;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private EnrollmentRepository enrollmentRepository;

  @Autowired
  private Attendancerepository attendaceRepository;

  @Autowired
  private TeacherSubjectRepository teacherSubjectRepository;

  @Autowired
  private YearRepository yearRepository;

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private SemRepository semRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private SelectedCourseDetailsRepository selectedCourseDetailsRepository;

  @Autowired
  private SelectedCourseDetailsService selectedCourseDetailsService;

  @GetMapping("/dashboard")
  public String teacher_page(Model model,Principal principal) {
   // Teacher teacher = new Teacher();
    String email = "";
    if (principal != null) {
      email = principal.getName();
    }
    model.addAttribute("email", email);
    Optional<Teacher> optionalTeacher = teacherRepository.findByEmail(email);
    Long teacher_id;
    if (optionalTeacher.isPresent()) {
      Teacher teacher = optionalTeacher.get();

    model.addAttribute("teacher", teacher);}
    else{
      System.out.println("Invalid User");}

    
    return "teacher/teacher_page";
  }

  @GetMapping("/attendance")
  public String showAttendancePage(Model model, Principal principal) {

    String email = "";
    if (principal != null) {
      email = principal.getName();
    }
    model.addAttribute("email", email);
    Optional<Teacher> optionalTeacher = teacherRepository.findByEmail(email);
    Long teacher_id;
    if (optionalTeacher.isPresent()) {
      teacher_id = optionalTeacher.get().getId();

      Optional<TeacherSubject> teacherSubjects = teacherSubjectRepository.findById(teacher_id);
      if (teacherSubjects.isPresent()) {
        Course courses = teacherSubjects.get().getCourse();
        Year years = teacherSubjects.get().getYear();
        Sem sems = teacherSubjects.get().getSemester();

        Long course_id = teacherSubjects.get().getCourse().getCourse_id();
        Long year_id = teacherSubjects.get().getYear().getYear_id();
        Long sem_id = teacherSubjects.get().getSemester().getSem_id();
        List<Course> course = teacherService.getCourseForTeacher(teacher_id);
        List<Year> year = teacherService.getYearForTeacher(teacher_id);
        List<Sem> sem = teacherService.getSemesterForTeacher(teacher_id);
        // List<Subject>
        // subject=teacherService.getSubjectsForTeacher(teacher_id,course_id,year_id,sem_id);
        List<Subject> subject = teacherService.getSubjectsForTeacher(teacher_id);
        System.out.println("TeacherSubject:" + course + " " + year + " " + sem + " " + subject);
        model.addAttribute("course", course);
        model.addAttribute("year", year);
        model.addAttribute("sem", sem);

        model.addAttribute("subject", subject);

      }
      Enrollment enrollment = new Enrollment();
      model.addAttribute("enrollment", enrollment);
    }

    return "teacher/attendance";
  }

  // Fetch years, semesters, and subjects based on the selected course
  @GetMapping("/course/{course_id}/details")
  @ResponseBody
  public Map<String, List<?>> getCourseDetails(@PathVariable Long course_id) {

    List<Year> years = selectedCourseDetailsRepository.findDistinctYearsByCourseId(course_id);
    List<Sem> semesters = selectedCourseDetailsRepository.findDistinctSemestersByCourseId(course_id);
    List<Subject> subjects = selectedCourseDetailsRepository.findSubjectsByCourseYearSemester(course_id);
    System.out.println("Years: " + years);
    System.out.println("semesters: " + semesters);

    System.out.println("subjects: " + subjects);
    Map<String, List<?>> response = new HashMap<>();
    response.put("years", years);
    response.put("semesters", semesters);
    return response;
  }

  // Fetch students based on course, year, semester, and subject
  @GetMapping("/students")
  public String getStudents(@RequestParam Long course_id,
      @RequestParam Long year_id,
      @RequestParam Long sem_id,
      @RequestParam Long sub_id,
      Model model) {
    return "teacher/student-table";
  }

  @PostMapping("/saveAttendance")

  @PreAuthorize("hasRole('ROLE_TEACHER')") // Pre-authorize only for users with ROLE_TEACHER
  public String saveAttendance(
      @ModelAttribute Attendance attendance, RedirectAttributes redirectAttributes,
      Model model) {
    Long course_id = attendance.getCourse().getCourse_id();
    Long year_id = attendance.getYear().getYear_id();
    Long sem_id = attendance.getSem().getSem_id();
    Long sub_id = attendance.getSubject().getSub_id();
    try{
    if (attendance == null && attendance.getStudent().getStudent_id() == null) {
      System.out.println("Invalid student Please Check");
      model.addAttribute("fail", "Invalid Student");
      
      return "teacher/attendance";

    }

    else {
      Long student_id = attendance.getStudent().getStudent_id();
      System.out.println(
          "Student:" + student_id + " " + "Year:" + year_id + " " + "subject:" + sub_id + " " + "course:" + course_id);

      if (student_id == null) {
        System.out.println("Invalid student Please Check");
        model.addAttribute("fail", "Invalid Student");

        return "redirect:/teacher/attendance";

      } else {
        Optional<Enrollment> enrollments = enrollmentRepository.findById(student_id);
        Long cid = 0L, yid = 0L, sid = 0L;
        List<Subject> subid = new ArrayList<>();

        if (enrollments.isPresent()) {
          cid = enrollments.get().getCourse().getCourse_id();
          yid = enrollments.get().getYear().getYear_id();
          sid = enrollments.get().getSemester().getSem_id();
          subid = enrollments.get().getSubjects();
        }
        System.out.println("CID:" + cid + " " + "YID:" + yid + " " + "sid:" + sid + " " + "subID:" + subid);
        if (cid == course_id && yid == year_id && sem_id == sid) {
          for (Subject s : subid) {
            if (s.getSub_id() == sub_id) {
              attendaceRepository.save(attendance);
              model.addAttribute("success", "sucess");
              System.out.println("sav3ed subjct");

            } else {
              System.out.println("Invalid subjct");
              model.addAttribute("fail", "fail");
            }
          }
        } else {
          System.out.println("Invalid student");
          model.addAttribute("fail", "attendance faild");
          return "redirect:/teacher/attendance";

        }
      }

      redirectAttributes.addFlashAttribute("successMessage", "Attendance saved successfully!");
      System.out.println("successMessage");

    }}catch(Exception e)
    {
      return "redirect:/teacher/attendance";

    }
    return "redirect:/teacher/attendance";

  }

  @GetMapping("/viewReport")
  public String report(Principal principal, Model model) {

    String email = "";
    if (principal != null) {
      email = principal.getName();
    }
    model.addAttribute("email", email);
    Optional<Teacher> optionalTeacher = teacherRepository.findByEmail(email);
    Long teacher_id;
    if (optionalTeacher.isPresent()) {
      teacher_id = optionalTeacher.get().getId();

      Optional<TeacherSubject> teacherSubjects = teacherSubjectRepository.findById(teacher_id);
      if (teacherSubjects.isPresent()) {
        Course course = teacherSubjects.get().getCourse();
        Year year = teacherSubjects.get().getYear();
        Sem sem = teacherSubjects.get().getSemester();

        Long course_id = teacherSubjects.get().getCourse().getCourse_id();
        Long year_id = teacherSubjects.get().getYear().getYear_id();
        Long sem_id = teacherSubjects.get().getSemester().getSem_id();
        List<Course> courses = teacherService.getCourseForTeacher(teacher_id);
        List<Year> years = teacherService.getYearForTeacher(teacher_id);
        List<Sem> sems = teacherService.getSemesterForTeacher(teacher_id);
        List<Subject> subjects = teacherService.getSubjectsForTeacher(teacher_id);
        System.out.println("TeacherSubject:" + course + " " + year + " " + sem + " " + subjects);
        model.addAttribute("courses", courses);
        model.addAttribute("years", years);
        model.addAttribute("sems", sems);

        model.addAttribute("subjects", subjects);
      }
    }
    return "teacher/viewReport";
  }

  // Fetch students based on course, year, semester, and subject
  @GetMapping("/report")
  public String getStudentsReport(@RequestParam Long course_id,
      @RequestParam Long year_id,
      @RequestParam Long sem_id,
      @RequestParam Long sub_id,
      Model model,Principal principal) {
        String email = "";
        if (principal != null) {
          email = principal.getName();
        }
        model.addAttribute("email", email);
        Optional<Teacher> optionalTeacher = teacherRepository.findByEmail(email);
        Long teacher_id;
        if (optionalTeacher.isPresent()) {
          teacher_id = optionalTeacher.get().getId();
          Optional<TeacherSubject> teacherSubjects = teacherSubjectRepository.findById(teacher_id);
      if (teacherSubjects.isPresent()) {
    
    List<AttendanceReport> attendanceReport = attendaceRepository
        .getAttendanceReportByCourseSubjectSemesterYear(course_id, year_id, sem_id, sub_id);

    for(AttendanceReport list:attendanceReport){
        System.out.println("Course:"+list.getCourse());
        System.out.println("Year:"+list.getYear());    
        System.out.println("Sem:"+list.getSem());
        System.out.println("Subject:"+list.getSubject());}

    model.addAttribute("attendanceReport", attendanceReport);
      }}

    return "teacher/reportTable";
  }

  @GetMapping("/addTeacher")
  public String addTeacher(Model model) {

    Teacher teacher = new Teacher();
    model.addAttribute("teacher", teacher);
    return "admin/addTeacher";
  }

  @PostMapping("/saveteacher")
  public String saveTeacher(@ModelAttribute Teacher teacher, Model model) {
    // TODO: process POST request
    teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
    teacher.setRole(Roles.TEACHER);
    teacherRepository.save(teacher);
    System.out.println("saved teacher");
    return "admin/addTeacher";
  }

  @GetMapping("/getSubjects")
  @ResponseBody
  public ResponseEntity<List<Subject>> getSubjects(Model model, @RequestParam Long course_id,
      @RequestParam Long year_id, @RequestParam Long sem_id) {
    List<Subject> subject = selectedCourseDetailsService.getSubjectsByCourseYearSemester(course_id, year_id, sem_id);
    System.out.println(
        "Received: course_id=" + course_id + ", year_id=" + year_id + ", sem=" + sem_id + " " + "subject:" + subject);

    model.addAttribute("subject", subject);
    return ResponseEntity.ok(subject);

  }
}
