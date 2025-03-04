package com.ams.Attendance_Management_System.config;

import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.Attendance;
import com.ams.Attendance_Management_System.models.Course;
import com.ams.Attendance_Management_System.models.Enrollment;
import com.ams.Attendance_Management_System.models.Sem;
import com.ams.Attendance_Management_System.models.Student;
import com.ams.Attendance_Management_System.models.Subject;
import com.ams.Attendance_Management_System.models.Teacher;
import com.ams.Attendance_Management_System.models.Year;
import com.ams.Attendance_Management_System.repository.AdminRepository;
import com.ams.Attendance_Management_System.repository.Attendancerepository;
import com.ams.Attendance_Management_System.repository.CourseRepository;
import com.ams.Attendance_Management_System.repository.EnrollmentRepository;
import com.ams.Attendance_Management_System.repository.SemRepository;
import com.ams.Attendance_Management_System.repository.StudentRepository;
import com.ams.Attendance_Management_System.repository.SubjectRepository;
import com.ams.Attendance_Management_System.repository.TeacherRepository;
import com.ams.Attendance_Management_System.repository.YearRepository;
import com.ams.Attendance_Management_System.service.AttendanceService;
import com.ams.Attendance_Management_System.util.constants.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

   @Autowired
   private CourseRepository courseRepository;
   @Autowired
   private YearRepository yearRepository;
   @Autowired
   private SemRepository semesterRepository;
   @Autowired
   private SubjectRepository subjectRepository;
   @Autowired
   private StudentRepository studentRepository;
   @Autowired
   private EnrollmentRepository enrollmentRepository;
   @Autowired
   private TeacherRepository teacherRepo;
   @Autowired
   private AdminRepository adminRepository;

   @Autowired
   AttendanceService attendanceService;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @Override
   public void run(String... args) throws Exception {

      Admin admin = new Admin();
      admin.setFull_name("ABC");
      admin.setEmail("davidJones@iit.ac.in");
      admin.setPassword(passwordEncoder.encode("123"));
      admin.setRole(Roles.ADMIN);
      adminRepository.save(admin);

      Teacher teacher = new Teacher();
      teacher.setFull_name("David Son");
      teacher.setEmail("david@gmail.com");
      teacher.setPassword(passwordEncoder.encode("david123"));
      teacher.setAddress("New York");
      teacher.setMobile_no(9877892123L);
      teacher.setRole(Roles.TEACHER); // Enum role
      // teacher.setTeachercourse(null);
      teacherRepo.save(teacher);

      // Seeding Courses
      Course course1 = new Course();
      course1.setCourse_name("Computer Science");
      Course course2 = new Course();
      course2.setCourse_name("Electrical Engineering");

      /*
       * List<Year> years=yearRepository.findAll();
       * course1.setYears(years);
       * course2.setYears(years);
       */
      courseRepository.saveAll(List.of(course1, course2));

      // Seeding Years
      Year year1 = new Year();
      // year1.setYear_id(1L);
      year1.setYear("First Year");
      yearRepository.save(year1);

      Year year2 = new Year();
      // year2.setYear_id(2L);
      year2.setYear("Second Year");

      yearRepository.save(year2);

      Year year3 = new Year();
      // year3.setYear_id(3L);
      year3.setYear("Third Year");

      yearRepository.save(year3);

      Year year4 = new Year();
      // year4.setYear_id(4L);

      year4.setYear("Fourth Year");
      yearRepository.save(year4);

      /*
       * List<Year> yr1=new ArrayList<>();
       * yr1.add(year1);yr1.add(year2);yr1.add(year3);yr1.add(year4);
       */
      // yearRepository.save(yr1);//All(List.of(year1, year2, year3, year4));

      // courseRepository.saveAll(List.of(1, 2, 3, 4));
      // Seeding Semesters
      Sem sem1 = new Sem();
      sem1.setSem("Semester 1");
      // sem1.setYear(year1);
      Sem sem2 = new Sem();
      sem2.setSem("Semester 2");
      // sem2.setYear(year1);

      Sem sem3 = new Sem();
      sem3.setSem("Semester 3");
      // sem3.setYear(year2);

      Sem sem4 = new Sem();
      sem4.setSem("Semester 4");
      // sem4.setYear(year2);

      Sem sem5 = new Sem();
      sem5.setSem("Semester 5");
      // sem5.setYear(year3);

      Sem sem6 = new Sem();
      sem6.setSem("Semester 6");
      // sem6.setYear(year3);

      Sem sem7 = new Sem();
      sem7.setSem("Semester 7");
      // sem7.setYear(year4);

      Sem sem8 = new Sem();
      sem8.setSem("Semester 8");
      // sem1.setYear(year4);

      /*
       * sem1.setYear(year1);
       * sem2.setYear(year1);
       * sem3.setYear(year2);
       * sem4.setYear(year2);
       * sem5.setYear(year3);
       * sem6.setYear(year3);
       * sem7.setYear(year4);
       * sem8.setYear(year4);
       */
      semesterRepository.saveAll(List.of(sem1, sem2, sem3, sem4, sem5, sem6, sem7, sem8));

      /*
       * List<Sem> y1=new ArrayList<>();
       * y1.add(sem1);
       * y1.add(sem2);
       */
      /*
       * Year yr1=new Year();
       * yr1.setSemesters(y1);
       * 
       * 
       * yearRepository.save(yr1);
       */ // Seeding Subjects
      Subject sub1 = new Subject(); // first sem
      sub1.setSub_name("Chemistry");
      /*
       * sub1.setCourse(course1.getCourse_id());
       * sub1.setYear(year1.getYear_id());
       * sub1.setSem(sem1.getSem_id());
       */
      Subject sub2 = new Subject();
      sub2.setSub_name("Physics");
      /*
       * sub2.setCourse(course1.getCourse_id());
       * sub2.setYear(year1.getYear_id());
       * sub2.setSem(sem1.getSem_id());
       */

      Subject sub3 = new Subject(); // second sem
      sub3.setSub_name("Mathematics");
      /*
       * sub3.setCourse(course1.getCourse_id());
       * sub3.setYear(year1.getYear_id());
       * sub3.setSem(sem2.getSem_id());
       */

      Subject sub4 = new Subject(); // third
      sub4.setSub_name("C");
      /*
       * sub4.setCourse(course1.getCourse_id());
       * sub4.setYear(year2.getYear_id());
       * sub4.setSem(sem3.getSem_id());
       * 
       */
      Subject sub5 = new Subject(); // fourth sem
      sub5.setSub_name("C++");
      /*
       * sub5.setCourse(course1.getCourse_id());
       * sub5.setYear(year2.getYear_id());
       * sub5.setSem(sem4.getSem_id());
       */
      Subject sub6 = new Subject();
      /*
       * sub6.setCourse(course1.getCourse_id());
       * sub6.setYear(year2.getYear_id());
       * sub6.setSem(sem4.getSem_id());
       */

      Subject sub7 = new Subject(); // fifth sem
      sub7.setSub_name("Java");
      /*
       * sub7.setCourse(course1.getCourse_id());
       * sub7.setYear(year3.getYear_id());
       * sub7.setSem(sem5.getSem_id());
       */

      Subject sub8 = new Subject(); // 6th sem--3
      sub8.setSub_name("AI");
      /*
       * sub8.setCourse(course1.getCourse_id());
       * sub8.setYear(year3.getYear_id());
       * sub8.setSem(sem6.getSem_id());
       */

      Subject sub9 = new Subject(); // 7th
      sub9.setSub_name("Project");
      /*
       * sub9.setCourse(course1.getCourse_id());
       * sub9.setYear(year4.getYear_id());
       * sub9.setSem(sem7.getSem_id());
       */

      Subject sub10 = new Subject(); // 8th
      sub10.setSub_name("Internship");
      /*
       * sub10.setCourse(course1.getCourse_id());
       * sub10.setYear(year4.getYear_id());
       * sub10.setSem(sem8.getSem_id());
       */

      subjectRepository.saveAll(List.of(sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, sub10));

      // Seeding Students
      Student student1 = new Student();
      student1.setFull_name("John Doe");
      Student student2 = new Student();
      student2.setFull_name("Jane Smith");
      studentRepository.saveAll(List.of(student1, student2));

      // Seeding Enrollments
      /*
       * Enrollment enroll1 = new Enrollment(student1, course1, year1, sem1, sub1);
       * Enrollment enroll2 = new Enrollment(student2, course1, year1, sem1, sub2);
       * Enrollment enroll3 = new Enrollment(student1, course2, year2, sem2, sub2);
       * enrollmentRepository.saveAll(List.of(enroll1, enroll2, enroll3));
       */
      /*
       * student1.setEnrollment(enroll1);
       * studentRepository.save(student1);
       * 
       * student2.setEnrollment(enroll2);
       * studentRepository.save(student2);
       */ /*
           * Attendance attendance=new Attendance();
           * attendance.setCourse("Computer Science");
           * attendance.setYear("First");
           * attendance.setSem("Sem 1");
           * attendance.setSubject("FDN");
           * List<Enrollment> id=new ArrayList<>();
           * id.add(enroll1);
           * // attendance.setEnrollments(enroll1.getId());
           * attendance.setStudent("ABC");
           * // attendance.setDate('11/02/1990');
           * attendance.setStatus("Present");
           * attendanceService.save(attendance);
           */
      /*
       * Attendance attendance=new Attendance();
       * attendance.setCourse(1L);
       * attendance.setYear(1L);
       * attendance.setSem(1L);
       * attendance.setSubject(1L);
       * attendance.setDateTime(LocalDateTime.of(2025, 2, 6, 9, 30));
       * attendance.setStudent_id(1L);
       * attendance.setStatus("PRESENT");
       * 
       * attendanceService.save(attendance);
       * 
       * 
       * Attendance attendance1=new Attendance();
       * attendance.setCourse(1L);
       * attendance.setYear(1L);
       * attendance.setSem(1L);
       * attendance.setSubject(1L);
       * attendance.setDateTime(LocalDateTime.of(2025, 2, 6, 9, 30));
       * attendance.setStudent_id(2L);
       * attendance.setStatus("PRESENT");
       * attendanceService.save(attendance1);
       */
      System.out.println("Database seeded successfully!");
   }
}
