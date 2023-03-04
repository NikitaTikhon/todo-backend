package com.todo.service.impl;

import com.todo.dto.request.MessageRequest;
import com.todo.dto.response.MessageResponse;
import com.todo.mapper.MessageMapper;
import com.todo.model.Message;
import com.todo.repository.MessageRepository;
import com.todo.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageServiceImpl(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public MessageResponse save(MessageRequest messageRequest) {
        Message message = messageMapper.messageRequestToMessage(messageRequest);
        messageRepository.save(message);
        return messageMapper.messageToMessageResponse(message);
    }

    @Override
    public List<MessageResponse> findAllByTaskId(Long id) {
        return messageMapper.messagesToMessageResponses(messageRepository.findAllByTaskId(id));
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
