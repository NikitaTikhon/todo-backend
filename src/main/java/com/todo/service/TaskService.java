package com.todo.service;

import com.todo.dto.request.TaskRequest;
import com.todo.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    TaskResponse save(TaskRequest taskRequest);
    TaskResponse findById(Long id);
    List<TaskResponse> findAllByUserId(Long id);
    TaskResponse update(TaskRequest taskRequest);
    void delete(Long id);
}
