package com.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequest {

    @Size(min = 3, max = 25, message = "username between 3 and 25 characters")
    @NotBlank(message = "username cannot be empty")
    private String username;
    @Size(min = 6, max = 30, message = "password between 6 and 30 characters")
    @NotBlank(message = "password cannot be empty")
    private String password;
}
