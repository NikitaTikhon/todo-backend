package com.todo.controller;

import com.todo.dto.request.MessageRequest;
import com.todo.dto.response.MessageResponse;
import com.todo.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/save-message")
    public ResponseEntity<MessageResponse> saveMessage(@RequestBody @Valid MessageRequest messageRequest) {
        MessageResponse messageResponse = messageService.save(messageRequest);
        return ResponseEntity.ok(messageResponse);
    }

    @GetMapping("/all-task-{id}-messages")
    public ResponseEntity<List<MessageResponse>> getAllTaskMessages(@PathVariable("id") Long id) {
        List<MessageResponse> messageResponses = messageService.findAllByTaskId(id);
        return ResponseEntity.ok(messageResponses);
    }

    @DeleteMapping("/delete-task-message-{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable("id") Long id) {
        messageService.delete(id);
        return ResponseEntity.ok().build();
    }
}