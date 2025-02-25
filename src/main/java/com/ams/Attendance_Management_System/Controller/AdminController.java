package com.ams.Attendance_Management_System.Controller;

import java.security.Principal;
import java.util.List;
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

import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.models.SelectedCourseDetails;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Teacher;
import com.ams.Attendance_Management_System.models.TeacherSubject;
import com.ams.Attendance_Management_System.models.Year;
import com.ams.Attendance_Management_System.models.Student;
import com.ams.Attendance_Management_System.repository.AdminRepository;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.EnrollmentRepository;
import com.ams.Attendance_Management_System.repository.SelectedCourseDetailsRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.StudentRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.TeacherRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;
import com.ams.Attendance_Management_System.service.AdminService;
import com.ams.Attendance_Management_System.service.CourseService;
import com.ams.Attendance_Management_System.service.EnrollmentService;
import com.ams.Attendance_Management_System.service.SelectedCourseDetailsService;
import com.ams.Attendance_Management_System.service.SubjectService;
import com.ams.Attendance_Management_System.service.TeacherService;
import com.ams.Attendance_Management_System.util.constants.Roles;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private SubjectService subjectService;

  @Autowired
  private SelectedCourseDetailsService selectedCourseDetailsService;
  @Autowired
  private SelectedCourseDetailsRepository selectedCourseRepository;
  @Autowired
  private AdminService adminService;

  @Autowired
  private TeacherService teacherSubjectService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private YearRepository yearRepository;

  @Autowired
  private SemRepository semRepository;

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private EnrollmentService enrollmentService;

  @Autowired
  private CourseService courseService;

  @Autowired
  private EnrollmentRepository enrollmentRepository;

  @Autowired
  private SelectedCourseDetailsService service;

  @GetMapping("/dashboard")

  public String admin_page(Model model, Principal principal) {
    // Admin admin = new Admin();

    String email = "email";
    if (principal != null) {
      email = principal.getName();
    }
    Optional<Admin> adminAccount = adminService.findByEmail(email);
    if (adminAccount.isPresent()) {
      Admin admin = adminAccount.get();
      model.addAttribute("admin", admin);
    }else{
    System.out.println("Invalid User");}

    return "admin/admin_page";
  }

  /*
   * @PostMapping("/dashboard")
   * public String admin_profile(Model model,Principal principal) {
   * //TODO: process POST request
   * 
   * 
   * String email="email";
   * if(principal!=null)
   * {
   * email=principal.getName();
   * }
   * Optional<Admin> admin=adminService.findByEmail(email);
   * if(admin.isPresent())
   * {
   * model.addAttribute("admin", admin);
   * }
   * System.out.println("Invalid User");
   * //Admin admin=
   * return "admin/admin_page";
   * }
   */
    @PreAuthorize("isAuthenticated()")

  @GetMapping("/addCourse")

  public String addCourse(Model model) {

    List<Course> courses = courseRepository.findAll();
    List<Year> years = yearRepository.findAll();
    List<Sem> semesters = semRepository.findAll();
    List<Subject> subjects = subjectRepository.findAll();
    // Add data to the model
    model.addAttribute("courses", courses);
    model.addAttribute("years", years);
    model.addAttribute("semesters", semesters);

    model.addAttribute("subjects", subjects);

    return "admin/course-form";
  }

  @PostMapping("/addCourse")

  public String addCourse(@ModelAttribute SelectedCourseDetails selectedCourse, 
  @RequestParam("subject") List<Subject> subjects,
      Model model) {
    Long course_id = selectedCourse.getCourse().getCourse_id();
    Long year_id = selectedCourse.getYear().getYear_id();
    Long sem_id = selectedCourse.getSem().getSem_id();
    System.out.print("course:" + course_id + " " + year_id + " " + sem_id);

    selectedCourse.setSubjects(subjects);

    System.out.println("Course Saved");
    service.save(selectedCourse);
    System.out.println("Course Saved");
    return "admin/course-form";
  }

  @GetMapping("/addTeacher")
  public String addTeacher(Model model) {

    List<Course> courses = courseService.findAll();
    model.addAttribute("courses", courses);

    List<Year> years = yearRepository.findAll();
    model.addAttribute("years", years);

    List<Sem> semesters = semRepository.findAll();
    model.addAttribute("semesters", semesters);

    Teacher teacher = new Teacher();
    model.addAttribute("teacher", teacher);
    return "admin/addTeacher";
  }

  @GetMapping("/add_student")
  public String add_student(Model model) {

    List<Course> courses = courseService.findAll();
    model.addAttribute("courses", courses);

    Student student = new Student();
    model.addAttribute("student", student);
    return "admin/addStudent";
  }

  public String getMethodName(@RequestParam String param) {
    return new String();
  }

  // Fetch years, semesters, and subjects based on the selected course
  @GetMapping("/course")
  public String showAddEnrollmentForm(@RequestParam(name = "courseId", required = false) Long courseId, Model model) {
    List<Course> courses = courseRepository.findAll(); // Fetch all courses

    List<Year> years = yearRepository.findAll();

    model.addAttribute("courses", courses);
    model.addAttribute("years", years);
    return "ok";
  }

  @PostMapping("/saveteacher")
  public String saveTeacher(@ModelAttribute Teacher teacher, Model model) {
    teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
    teacher.setRole(Roles.TEACHER);
    teacherRepository.save(teacher);
    System.out.println("saved teacher");
    return "admin/admin_page";
  }

  @GetMapping("/viewTeacher")
  public String viewTeacher(Model model) {

    List<Teacher> teacher = teacherRepository.findAll();
    model.addAttribute("teacher", teacher);

    return "admin/viewTeacher";
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/viewTeacher/{id}/updateTeacher")
  public String updateTeacher(@PathVariable Long id, Model model) {

    System.out.println("updte teacher form1");
    List<Teacher> teacher1 = teacherRepository.findAll();

    List<Course> courses = courseService.findAll();

    List<Year> year = yearRepository.findAll();
    List<Sem> sem = semRepository.findAll();
    List<Subject> subject = subjectRepository.findAll();
    model.addAttribute("teacher", teacher1);

    model.addAttribute("courses", courses);
    model.addAttribute("year", year);
    model.addAttribute("sem", sem);
    model.addAttribute("subject", subject);

    return "admin/updateTeacher";
  }

  @GetMapping("/addStudent")
  public String saveStudent(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    model.addAttribute("student", student);
    return "admin/addStudent";
  }

  @PostMapping("/saveStudent")
  public String saveStudent(@ModelAttribute Student student, Model model) {

    System.out.println("Enrolled enter");

    studentRepository.save(student);
    System.out.println("Student Sucess");
    return "admin/addStudent";
  }

  /* @PostMapping("/saveEnrollmentw")
  public String saveEnrollment(
      @RequestParam("student_id") Long studentId,
      @RequestParam("course_id") Long courseId,
      @RequestParam("year_id") Long yearId,
      @RequestParam("sem_id") Long semesterId,
      @RequestParam("subjectIds") List<Long> subjectIds) {

    Enrollment enrollment = new Enrollment();
    enrollment.setStudent(studentRepository.findById(studentId).orElseThrow());
    enrollment.setCourse(courseRepository.findById(courseId).orElseThrow());
    enrollment.setYear(yearRepository.findById(yearId).orElseThrow());
    enrollment.setSemester(semRepository.findById(semesterId).orElseThrow());
    enrollmentRepository.save(enrollment);
    System.out.println("saved enrollment");
    enrollmentRepository.save(enrollment);

    System.out.println("Enrolled Sucess");
    return "admin/admin_page";

  }
 */
  @PostMapping("/saveEnrollment")

  public String saveEnrollment(@ModelAttribute Enrollment enrollment, Model model) {
    Long student_id = enrollment.getStudent().getStudent_id();
    Long course_id = enrollment.getCourse().getCourse_id();
    System.out.println(" enrollment course:" + course_id);

    Long year_id = enrollment.getYear().getYear_id();
    System.out.println(" enrollment year:" + year_id);

    Long sem_id = enrollment.getSemester().getSem_id();
    System.out.println(" enrollment sem:" + sem_id);

    Optional<Student> student = studentRepository.findById(student_id);
    Student students = student.get();
    // ✅ Prevent duplicate enrollment for the same student
    if (enrollmentRepository.existsByStudent(student)) {
      // throw new IllegalStateException("Student is already enrolled.");
      model.addAttribute("StudentMSG", "Student is already enrolled");
      return "admin/addEnrollment";
    }

    else {
      List<Subject> subjects = selectedCourseDetailsService.getSubjectsByCourseYearSemester(course_id, year_id, sem_id);

      enrollment.setSubjects(subjects);
      System.out.println("saved enrollment" + subjects);
      enrollmentRepository.save(enrollment);

      System.out.println("Enrolled Sucess");

      return "admin/addEnrollment";
    }
  }

  @GetMapping("/addEnrollment")
  public String addEnrollment(@ModelAttribute Enrollment enrollment, Principal principla,
    Model model) {

    List<Student> students = studentRepository.findAll();

    List<Course> courses = courseService.findAll();
    List<Year> years = yearRepository.findAll();
    List<Sem> semesters = semRepository.findAll();
    model.addAttribute("students", students);
    model.addAttribute("courses", courses);
    model.addAttribute("years", years);
    model.addAttribute("semesters", semesters);
    return "admin/addEnrollment";
  }

  @GetMapping("/viewEnrollment")
  public String viewEnrollment(Model model) {
      
      List<Enrollment> enrollments=enrollmentRepository.findAll();
      model.addAttribute("enrollments",enrollments); 
      return "admin/viewEnrollment";
  }
  @GetMapping("/updateEnrollment/{id}")
  public String showUpdateEnrollmentForm(@PathVariable("id") Long id, Model model) {
      Enrollment enrollment = enrollmentService.getEnrollmentsById(id);
      
      if (enrollment == null) {
          model.addAttribute("error", "Enrollment not found!");
          return "admin/errorPage";  // Show error page if enrollment is missing
      }
      System.out.println("Enrollment ID: " + id);
      //Student student_id=enrollmentRepository.findStudentByEnrollmentId(id);
      /* System.out.println("SID:"+student_id);
      Optional<Student> student=studentRepository.findById(student_id.getStudent_id());
      Student students=student.get();
       *///System.out.println("Student:"+students);
      model.addAttribute("enrollment", enrollment);
      model.addAttribute("courses", courseRepository.findAll());
      model.addAttribute("years", yearRepository.findAll());
      model.addAttribute("semesters", semRepository.findAll());
      model.addAttribute("subjects", subjectRepository.findAll());
      //model.addAttribute("students", students);
      return "admin/updateEnrollment";  // Return Thymeleaf template name
  } 
  @GetMapping("/viewStudent")
  public String viewStudent(Model model) {
      
      List<Student> students=studentRepository.findAll();
      model.addAttribute("students",students); 
      return "admin/viewStudent";
  }
  

  @PostMapping("/updateEnrollment/{id}")
  public String updateEnrollment(@ModelAttribute Enrollment enrollment,@RequestParam Student student,Model model)
  {
  //  Enrollment enrollment = enrollmentService.getEnrollmentsById(id);
    Enrollment e;
    if (enrollment == null) {
        model.addAttribute("error", "Enrollment not found!");
        return "admin/errorPage"; 
    }
    List<Subject> subjects=enrollment.getSubjects();
    // Update course, year, semester, and subjects
    Course course = courseRepository.findById(enrollment.getCourse().getCourse_id()).orElseThrow();
    Year year = yearRepository.findById(enrollment.getYear().getYear_id()).orElseThrow();
    Sem semester = semRepository.findById(enrollment.getSemester().getSem_id()).orElseThrow();
   // Student student=studentRepository.findById(enrollment.getStudent().getStudent_id()).orElseThrow();
   // List<Subject> subjects = subjectRepository.findAllById(subjects.g);
 //  System.out.println("SID:"+student);
    
   // enrollment.setStudent(student);
   /* Long stdid=enrollment.getStudent().getStudent_id();
   studentRepository.findById(stdid);
   Optional<Student> student=studentRepository.findById(stdid);
   Student std=student.get();
    */
 /*    Student std=studentRepository.findById(student_id);
    System.out.println("SID:"+stdid);
  */   //Student stdd=enrollment.getStudent().
 /*  Optional<Student> student=studentRepository.findById(student_id);
   Student std=student.get();
  */  
  System.out.println("SID:"+student);
  System.out.println("SubID:"+enrollment.getSubjects());

  enrollment.setStudent(student);
    enrollment.setCourse(course);
    enrollment.setYear(year);
    enrollment.setSemester(semester);
    //enrollment.setSubjects(subjects);

    enrollmentService.updateEnrollment(enrollment);

      return "admin/addEnrollment";
  }
/* 
  @GetMapping("/{id}/deleteEnrollment")
  public void deleteEnrollment(@PathVariable("id") Long id,@ModelAttribute Enrollment enrollment,Model model)
  {
       enrollmentRepository.deleteById(id);
       System.out.println("deleted");
  }
 */  @GetMapping("/addSubject")
  public String addTeacherSubjects(@ModelAttribute TeacherSubject teacherSubject, Model model) {
    model.addAttribute("teacherSubject", teacherSubject);

    List<Teacher> teachers = teacherRepository.findAll();

    List<Course> courses = courseService.findAll();

    List<Year> years = yearRepository.findAll();
    List<Sem> semesters = semRepository.findAll();
    List<Subject> subject = subjectRepository.findAll();
    model.addAttribute("teachers", teachers);

    model.addAttribute("courses", courses);
    model.addAttribute("years", years);
    model.addAttribute("semesters", semesters);
    model.addAttribute("subject", subject);

    return "admin/addSubject";
  }

  @PostMapping("/saveTeacherSubject")
  public String saveTeacherSubject(@ModelAttribute TeacherSubject teacherSubject, Model model) {

    Long course_id = teacherSubject.getCourse().getCourse_id();
    System.out.println(" enrollment course:" + course_id);

    Long year_id = teacherSubject.getYear().getYear_id();
    System.out.println(" enrollment year:" + year_id);

    Long sem_id = teacherSubject.getSemester().getSem_id();
    System.out.println(" enrollment sem:" + sem_id);
    System.out.println("Teacher Subject Form");
    teacherSubjectService.save(teacherSubject);
    System.out.println("Teacher Subject Saved");

    return "admin/addSubject";
  }

  @GetMapping("/getSubjects")
  @ResponseBody
  public ResponseEntity<List<Subject>> getSubjects(Model model, @RequestParam Long course_id,
      @RequestParam Long year_id, @RequestParam Long sem_id) {
    List<Subject> subject = selectedCourseDetailsService.getSubjectsByCourseYearSemester(course_id, year_id, sem_id);
    model.addAttribute("subject", subject);
    return ResponseEntity.ok(subject);

  }
}
