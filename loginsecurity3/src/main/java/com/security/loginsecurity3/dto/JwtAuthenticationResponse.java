package com.security.loginsecurity3.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    
    private String token;
    private String refreshToken;
}
