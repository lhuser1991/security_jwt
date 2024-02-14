package com.security.loginsecurity3.services;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.loginsecurity3.dto.JwtAuthenticationResponse;
import com.security.loginsecurity3.dto.RefreshTokenRequest;
import com.security.loginsecurity3.dto.SignUpRequest;
import com.security.loginsecurity3.dto.SigninRequest;
import com.security.loginsecurity3.models.Roles;
import com.security.loginsecurity3.models.Users;
import com.security.loginsecurity3.repositories.RolesRepository;
import com.security.loginsecurity3.repositories.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    
    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    private final RolesRepository rolesRepository;

    @Override
    public Users signup(SignUpRequest signUpRequest) {
        Users users = new Users();
        users.setEmail(signUpRequest.getEmail());
        users.setFirstname(signUpRequest.getFirstname());
        users.setSecondname(signUpRequest.getLastname());
        users.setRole(rolesRepository.findByName("USER"));
        users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return usersRepository.save(users);
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));

        Users users = usersRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    
        String jwt = jwtService.generateToken(users);

        String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), users);

        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);

        return jwtAuthenticationResponse;
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        Users users = usersRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(refreshTokenRequest.getToken(), users)) {
            String jwt = jwtService.generateToken(users);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(jwt);
            jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

            return jwtAuthenticationResponse;
        }
        return null;
    }
}
