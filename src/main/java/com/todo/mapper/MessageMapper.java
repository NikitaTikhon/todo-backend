package com.todo.mapper;

import com.todo.dto.request.MessageRequest;
import com.todo.dto.response.MessageResponse;
import com.todo.model.Message;
import com.todo.service.impl.TaskServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TaskServiceImpl.class})
public interface MessageMapper {
    @Mapping(target = "task", source = "taskId")
    Message messageRequestToMessage(MessageRequest messageRequest);
    MessageResponse messageToMessageResponse(Message message);
    List<MessageResponse> messagesToMessageResponses(List<Message> messages);
}
