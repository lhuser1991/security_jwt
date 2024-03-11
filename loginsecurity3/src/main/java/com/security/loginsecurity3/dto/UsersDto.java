package com.security.loginsecurity3.dto;

import com.security.loginsecurity3.models.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto {
    
    private Long id;
    private String firstname;
    private String secondname;
    private String email;
    private Long idRole;

    public UsersDto(Users user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.secondname = user.getSecondname();
        this.email = user.getEmail();
        this.idRole = user.getRole().getId();
    }

}
