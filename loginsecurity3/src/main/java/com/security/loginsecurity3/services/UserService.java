package com.security.loginsecurity3.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.security.loginsecurity3.dto.UsersDto;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    
    UserDetailsService userDetailsService();

    // UsersDto getUserInformationFromCookie(HttpServletRequest request);

}
