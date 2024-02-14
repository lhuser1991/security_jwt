package com.security.loginsecurity3.services;

import com.security.loginsecurity3.dto.JwtAuthenticationResponse;
import com.security.loginsecurity3.dto.RefreshTokenRequest;
import com.security.loginsecurity3.dto.SignUpRequest;
import com.security.loginsecurity3.dto.SigninRequest;
import com.security.loginsecurity3.models.Users;

public interface AuthenticationService {
    
    Users signup(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signin(SigninRequest signinRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
