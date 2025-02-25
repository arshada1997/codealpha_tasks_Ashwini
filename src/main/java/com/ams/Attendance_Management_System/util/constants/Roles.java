package com.ams.Attendance_Management_System.util.constants;

import lombok.Getter;

@Getter
public enum Roles {

    USER("ROLE_USER"),ADMIN("ROLE_ADMIN"),STUDENT("ROLE_STUDENT"),TEACHER("ROLE_TEACHER");
    

    private final String authority;

    Roles(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }}

