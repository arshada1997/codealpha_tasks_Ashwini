package com.ams.Attendance_Management_System.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.ams.Attendance_Management_System.util.constants.Roles;

import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="useraccount")
public class UserAccount {

     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;

    @Column(name="full_name")
    private String full_name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="mobile_no")
    private long mobile_no;

    @Column(name="address")
    private String address;

    @Column(name="date_of_birth")
    private LocalDate date_of_birth;

    @Column(name="gender")
    private String gender;   

    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private Roles role;

   /*   @OneToMany(mappedBy = "account")
     private List<Post> posts;
 */
/* @ManyToMany(fetch = FetchType.EAGER)
     @JoinTable(
          name="account_authority",
          joinColumns={@JoinColumn(name="account_id",referencedColumnName="id")},
          inverseJoinColumns = {@JoinColumn(name="authority_id",referencedColumnName = "id")})
          private Set<Authority> authorities=new HashSet<>();
 */     
}
