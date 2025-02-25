package com.ams.Attendance_Management_System.Controller;

import com.ams.Attendance_Management_System.util.constants.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.UserAccount;
import com.ams.Attendance_Management_System.repository.AdminRepository;
import com.ams.Attendance_Management_System.service.StudentService;
import com.ams.Attendance_Management_System.service.TeacherService;

@Controller

public class HomeController {

  @Autowired
  private TeacherService teacherService;

  @Autowired
  private StudentService studentService;

  @Autowired
  private AdminRepository adminRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/")
  public String home(Model model) {
    return "home";
  }

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @GetMapping("/register")
  public String register(Model model) {
    // Teacher teacher=new Teacher();
    UserAccount teacher = new UserAccount();
    model.addAttribute("teacher", teacher);

    return "register";
  }

  @GetMapping("/aboutUs")
  public String aboutUs(Model model) {
    return "aboutUs";
  }

  @PostMapping("/saveregister")
  public String register(@ModelAttribute Admin admin, Model model) {

    System.out.println("register admin");

    admin.setPassword(passwordEncoder.encode(admin.getPassword()));

    admin.setRole(Roles.ADMIN);

    adminRepository.save(admin);

    return "redirect:/login";
  }

}