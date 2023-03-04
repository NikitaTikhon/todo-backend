package com.todo.controller;

import com.todo.dto.request.LoginRequest;
import com.todo.dto.request.SignupRequest;
import com.todo.dto.response.JwtResponse;
import com.todo.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:3000")
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.authenticate(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid SignupRequest signUpRequest) {
        authService.register(signUpRequest);
        return ResponseEntity.ok().build();
    }
}
