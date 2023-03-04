package com.todo.repository;

import com.todo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles"})
    Optional<User> findByUsername(String username);
    List<User> findUsersByIdNotIn(Collection<Long> ids);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
