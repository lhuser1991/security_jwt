package com.security.loginsecurity3.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.security.loginsecurity3.dto.JwtAuthenticationResponse;
import com.security.loginsecurity3.dto.RefreshTokenRequest;
import com.security.loginsecurity3.dto.SignUpRequest;
import com.security.loginsecurity3.dto.SigninRequest;
import com.security.loginsecurity3.dto.UsersDto;
import com.security.loginsecurity3.models.Users;
import com.security.loginsecurity3.services.AuthenticationService;
import com.security.loginsecurity3.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Users> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.signin(signinRequest, response));
    }

    // @GetMapping("/cookie")
    // public ResponseEntity<String> getCookie(HttpServletRequest request) {
    //     Cookie[] cookies = request.getCookies();

    //     if (cookies != null) {
    //         for (Cookie cookie : cookies) {
    //             System.out.println("Nom du cookie : " + cookie.getName());
    //             System.out.println("Valeur du cookie : " + cookie.getValue());
    //         }
    //     }

    //     return ResponseEntity.ok("Consultation des cookies effectuée"); 
    // }

    // @GetMapping("/userInfo")
    // public ResponseEntity<UsersDto> getUserInformationFromCookie(HttpServletRequest request) {
    //     return ResponseEntity.ok(userService.getUserInformationFromCookie(request));
    // }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }
    
}
