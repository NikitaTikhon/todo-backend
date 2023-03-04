package com.todo.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageResponse {
    private Long id;
    private String content;
    private Date dateCreation;
}
