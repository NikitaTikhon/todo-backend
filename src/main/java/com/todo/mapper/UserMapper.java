package com.todo.mapper;

import com.todo.dto.response.UserResponse;
import com.todo.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse userToUserResponse(User user);
    List<UserResponse> usersToUserResponses(List<User> users);
}
