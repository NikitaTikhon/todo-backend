package com.todo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SignupRequest {

    @Size(min = 3, max = 25, message = "username between 3 and 25 characters")
    @NotBlank(message = "username cannot be empty")
    private String username;
    @Email(message = "email invalid")
    @NotBlank(message = "email cannot be empty")
    private String email;

    @Size(max = 30, message = "firstname less than 30 characters")
    private String firstname;

    @Size(max = 30, message = "lastname less than 30 characters")
    private String lastname;

    @Size(min = 8, max = 30, message = "password between 6 and 30 characters")
    @NotBlank(message = "password cannot be empty")
    private String password;
}
