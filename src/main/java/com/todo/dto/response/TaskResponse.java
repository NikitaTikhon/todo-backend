package com.todo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TaskResponse {
    private Long id;
    private String title;
    private String content;
    private Date dateCreation;
}
