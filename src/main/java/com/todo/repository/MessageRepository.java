package com.todo.repository;

import com.todo.model.Message;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByTaskId(Long id);
    @Modifying
    @Query(value = "delete from Message m where m.id = :id")
    void deleteById(@NonNull @Param("id") Long id);
}
