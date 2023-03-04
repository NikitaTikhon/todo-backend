package com.todo.mapper;

import com.todo.dto.request.TaskRequest;
import com.todo.dto.response.TaskResponse;
import com.todo.model.Task;
import com.todo.service.impl.UserServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserServiceImpl.class})
public interface TaskMapper {
    @Mapping(target = "user", source = "userId")
    Task taskRequestToTask(TaskRequest taskRequest);
    TaskResponse taskToTaskResponse(Task task);
    List<TaskResponse> tasksToTaskResponses(List<Task> tasks);
}
