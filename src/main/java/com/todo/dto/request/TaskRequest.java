package com.todo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TaskRequest {
    private Long id;
    @NotBlank(message = "title cannot be empty")
    private String title;
    @NotBlank(message = "content cannot be empty")
    private String content;
    private Date dateCreation;
    private Long userId;
}
