package com.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageRequest {
    @NotBlank(message = "content cannot be empty")
    private String content;
    @NotNull(message = "taskId cannot be empty")
    private Long taskId;
}
