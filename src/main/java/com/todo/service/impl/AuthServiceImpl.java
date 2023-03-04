package com.todo.service.impl;

import com.todo.config.UserDetailsImpl;
import com.todo.config.jwt.JwtUtils;
import com.todo.constant.ExceptionMessage;
import com.todo.dto.request.LoginRequest;
import com.todo.dto.request.SignupRequest;
import com.todo.dto.response.JwtResponse;
import com.todo.mapper.AuthMapper;
import com.todo.model.User;
import com.todo.model.enums.ERole;
import com.todo.repository.RoleRepository;
import com.todo.repository.UserRepository;
import com.todo.service.AuthService;
import jakarta.persistence.EntityExistsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthMapper authMapper;
    private final JwtUtils jwtUtils;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, AuthMapper authMapper, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authMapper = authMapper;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public JwtResponse authenticate(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return JwtResponse.builder()
                .jwt(jwt)
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .email(userDetails.getEmail())
                .roles(roles)
                .build();
    }

    @Override
    public void register(SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new EntityExistsException(ExceptionMessage.USERNAME_EXIST);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EntityExistsException(ExceptionMessage.EMAIL_EXIST);
        }

        User user = authMapper.signUpRequestToUser(signUpRequest);
        user.setRoles(Collections.singleton(roleRepository.findByName(ERole.ROLE_USER)));

        userRepository.save(user);
    }
}
