package com.iluk.git.mainProj.data.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ADMIN":
                response.sendRedirect("/admin/dashboard");
                break;
            case "EMPLOYER":
                response.sendRedirect("/employer");
                break;
            case "COMPANY":
                response.sendRedirect("/companie");
                break;
            default:
                response.sendRedirect("/");
                break;
        }

    }

}