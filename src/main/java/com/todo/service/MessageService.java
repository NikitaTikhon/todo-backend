package com.todo.service;

import com.todo.dto.request.MessageRequest;
import com.todo.dto.response.MessageResponse;

import java.util.List;

public interface MessageService {
    MessageResponse save(MessageRequest messageRequest);
    List<MessageResponse> findAllByTaskId(Long id);
    void delete(Long id);

}
