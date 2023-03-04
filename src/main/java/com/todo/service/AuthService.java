package com.todo.service;

import com.todo.dto.request.LoginRequest;
import com.todo.dto.request.SignupRequest;
import com.todo.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticate(LoginRequest loginRequest);
    void register(SignupRequest signUpRequest);
}
