package com.mycompany.courseerpbackend.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("requestURI: " + request.getRequestURI()); // requestURI: /v1/auth/login
        System.out.println("requestURL: " + request.getRequestURL()); // requestURL: http://localhost:8080/v1/auth/login
        System.out.println("servletPath: " + request.getServletPath()); // servletPath: /v1/auth/login
        filterChain.doFilter(request, response);
        System.out.println("after filter"); // after filter
    }

}
