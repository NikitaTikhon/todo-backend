package com.todo.mapper.encoder;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordEncoderMapper {
    final PasswordEncoder passwordEncoder;
    @EncodingMapping
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
