package com.todo.service.impl;

import com.todo.constant.ExceptionMessage;
import com.todo.dto.request.TaskRequest;
import com.todo.dto.response.TaskResponse;
import com.todo.mapper.TaskMapper;
import com.todo.model.Task;
import com.todo.repository.TaskRepository;
import com.todo.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponse save(TaskRequest taskRequest) {
        Task task = taskMapper.taskRequestToTask(taskRequest);
        taskRepository.save(task);
        return taskMapper.taskToTaskResponse(task);
    }

    @Override
    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessage.TASK_NOT_FOUND));
        return taskMapper.taskToTaskResponse(task);
    }

    @Override
    public List<TaskResponse> findAllByUserId(Long id) {
        return taskMapper.tasksToTaskResponses(taskRepository.findAllByUserIdOrderByDateCreationDesc(id));
    }

    @Override
    public TaskResponse update(TaskRequest taskRequest) {
        Task task = taskMapper.taskRequestToTask(taskRequest);
        taskRepository.update(task.getId(), task.getTitle(), task.getContent());
        return taskMapper.taskToTaskResponse(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getReferenceById(Long taskId) {
        return taskRepository.getReferenceById(taskId);
    }
}
