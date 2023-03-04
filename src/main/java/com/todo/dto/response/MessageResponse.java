package com.todo.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageResponse {
    private Long id;
    private String content;
    @JsonFormat(pattern = "HH:mm dd.MM.yyyy")
    private Date dateCreation;
}
