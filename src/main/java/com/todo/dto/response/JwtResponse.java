package com.todo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class JwtResponse {
    private String jwt;
    private Long id;
    private String username;
    private String email;
    List<String> roles;
}
