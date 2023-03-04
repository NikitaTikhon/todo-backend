package com.todo.controller;

import com.todo.config.UserDetailsImpl;
import com.todo.dto.request.TaskRequest;
import com.todo.dto.response.TaskResponse;
import com.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/save-task")
    public ResponseEntity<TaskResponse> saveTask(@RequestBody @Valid TaskRequest taskRequest, @AuthenticationPrincipal UserDetailsImpl authUser) {
        taskRequest.setUserId(authUser.getId());
        TaskResponse taskResponse = taskService.save(taskRequest);
        return ResponseEntity.ok(taskResponse);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable("id") Long id) {
        TaskResponse taskResponse = taskService.findById(id);
        return ResponseEntity.ok(taskResponse);
    }

    @GetMapping("/all-tasks")
    public ResponseEntity<List<TaskResponse>> getTasks(@AuthenticationPrincipal UserDetailsImpl authUser) {
        List<TaskResponse> taskResponses = taskService.findAllByUserId(authUser.getId());
        return ResponseEntity.ok(taskResponses);
    }

    @PatchMapping("/update-task")
    public ResponseEntity<TaskResponse> updateTask(@RequestBody @Valid TaskRequest taskRequest, @AuthenticationPrincipal UserDetailsImpl authUser) {
        taskRequest.setUserId(authUser.getId());
        TaskResponse taskResponse = taskService.update(taskRequest);
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}