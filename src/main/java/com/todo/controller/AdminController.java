package com.todo.controller;

import com.todo.config.UserDetailsImpl;
import com.todo.dto.response.UserResponse;
import com.todo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/admin")
@CrossOrigin("http://localhost:3000")
@RestController
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user-list")
    public ResponseEntity<List<UserResponse>> getUsers(@AuthenticationPrincipal UserDetailsImpl authUser) {
        List<UserResponse> users = userService.findUsers(authUser.getId());
        return ResponseEntity.ok(users);
    }

}
