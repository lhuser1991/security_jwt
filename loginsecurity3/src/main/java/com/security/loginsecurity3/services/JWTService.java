package com.security.loginsecurity3.services;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import com.security.loginsecurity3.models.Users;

public interface JWTService {
    
    String generateToken(Users userDetails);
    String generateRefreshToken(Map<String, Object> extraClaims, Users userDetails);
    String extractUserName(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
