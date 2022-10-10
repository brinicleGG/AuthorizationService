package ru.brinicle.authorization.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

    private String email;
    private String password;
}
