package com.todo.mapper;

import com.todo.dto.request.SignupRequest;
import com.todo.mapper.encoder.EncodingMapping;
import com.todo.mapper.encoder.PasswordEncoderMapper;
import com.todo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PasswordEncoderMapper.class})
public interface AuthMapper {
    @Mapping(target = "password", source = "password", qualifiedBy = EncodingMapping.class)
    User signUpRequestToUser(SignupRequest signupRequest);
}
