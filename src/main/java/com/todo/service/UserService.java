package com.todo.service;

import com.todo.dto.response.UserResponse;
import com.todo.model.User;

import java.util.List;

public interface UserService {
    User getReferenceById(Long userId);
    List<UserResponse> findUsers(Long id);
}
