package com.todo.repository;

import com.todo.model.Task;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserIdOrderByDateCreationDesc (Long id);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.title =:title, t.content =:content where t.id =:id")
    void update(@Param("id") Long id, @Param("title") String title, @Param("content") String content);
    @Modifying
    @Query(value = "delete from Task t where t.id = :id")
    void deleteById(@NonNull @Param("id") Long id);
}