package com.todo.service.impl;

import com.todo.dto.response.UserResponse;
import com.todo.mapper.UserMapper;
import com.todo.model.User;
import com.todo.repository.UserRepository;
import com.todo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public User getReferenceById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

    @Override
    public List<UserResponse> findUsers(Long id) {
        List<User> users = userRepository.findUsersByIdNotIn(Collections.singleton(id));
        return userMapper.usersToUserResponses(users);
    }
}
