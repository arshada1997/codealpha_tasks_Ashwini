package com.ams.Attendance_Management_System.Controller;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutHandler {

    @GetMapping("/logout")
    @PreAuthorize("isAuthenticated()")

    public String logoutSuccess(HttpServletRequest request,
            HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/"; // View name for logout success page
    }

}
