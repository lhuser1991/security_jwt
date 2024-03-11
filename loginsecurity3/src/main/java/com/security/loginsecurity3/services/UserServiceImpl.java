package com.security.loginsecurity3.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.loginsecurity3.dto.UsersDto;
import com.security.loginsecurity3.models.Users;
import com.security.loginsecurity3.repositories.UsersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UsersRepository usersRepository;
    private final JWTServiceImpl jwtServiceImpl;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return usersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    // @Override
    // public UsersDto getUserInformationFromCookie(HttpServletRequest request) {
        
    //     Cookie[] cookies = request.getCookies();

    //     Cookie cookie = null;
    //     String cookieValue = "";

    //     for(Cookie c: cookies) {
    //         if(c.getName().equals("accessToken")) {
    //             cookie = c;
    //             cookieValue = cookie.getValue();
    //             break;
    //         }
    //     }

    //     Claims claims = Jwts.parserBuilder()
    //         .setSigningKey(jwtServiceImpl.getSigninKey())
    //         .build()
    //         .parseClaimsJws(cookieValue)
    //         .getBody();



    //     Long idUser = claims.get("id") instanceof Integer ? ((Integer) claims.get("id")).longValue() : (Long) claims.get("id");

    //     Long idRole = claims.get("idRole") instanceof Integer ? ((Integer) claims.get("idRole")).longValue() : (Long) claims.get("idRole");

    //     String firstnameUser = (String) claims.get("firstname");
    //     String secondnameUser = (String) claims.get("secondname");
    //     String emailUser = claims.getSubject();

    //     return new UsersDto(idUser, firstnameUser, secondnameUser, emailUser, idRole);
    // }


}
