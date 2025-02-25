package com.ams.Attendance_Management_System.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ams.Attendance_Management_System.models.Admin;
import com.ams.Attendance_Management_System.models.Teacher;
import com.ams.Attendance_Management_System.models.Student;
import com.ams.Attendance_Management_System.repository.AdminRepository;
import com.ams.Attendance_Management_System.repository.StudentRepository;
import com.ams.Attendance_Management_System.repository.TeacherRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TeacherRepository teacherRepo;

    /*
     * @Autowired
     * private PasswordEncoder passwordEncoder;
     */
    @Autowired
    private AdminRepository adminRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> grantedAutority = new ArrayList<>();

        Optional<Teacher> teacher = teacherRepo.findByEmail(email);
        if (teacher.isPresent()) {

            Teacher user = teacher.get();
            grantedAutority.add(new SimpleGrantedAuthority(user.getRole().getAuthority()));

            return new User(user.getEmail(), user.getPassword(), grantedAutority);
        }
        Optional<Admin> admin = adminRepo.findByEmail(email);

        if (admin.isPresent()) {
            Admin user = admin.get();
            grantedAutority.add(new SimpleGrantedAuthority(user.getRole().getAuthority()));
            return new User(user.getEmail(), user.getPassword(), grantedAutority);
        }

        Optional<Student> student = studentRepo.findByEmail(email);

        if (student.isPresent()) {
            Student user = student.get();
            grantedAutority.add(new SimpleGrantedAuthority(user.getRole().getAuthority()));
            return new User(user.getEmail(), user.getPassword(), grantedAutority);
        }
        throw new UsernameNotFoundException("User Not Found");

    }

    /*
     * Optional<UserAccount> optionalAccount = userRepo.findByEmail(email);
     * if(!optionalAccount.isPresent()){
     * throw new UsernameNotFoundException("Account not found");
     * }
     * UserAccount user = optionalAccount.get();
     * 
     * // List<GrantedAuthority> grantedAuthority = new ArrayList<>();
     * grantedAuthority.add(new SimpleGrantedAuthority(user.getRoles()));
     * /* Set<Authority> authorities = account.getAuthorities();
     * for(Authority _auth: authorities){
     * grantedAuthority.add(new SimpleGrantedAuthority(_auth.getName()));
     * }
     */

    // return new User(user.getEmail(), user.getPassword(), grantedAuthority);
    // }*/

}
