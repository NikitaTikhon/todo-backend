package com.todo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
public class ExceptionResponse {
    private Integer code;
    private String message;
    @JsonInclude(Include.NON_NULL)
    private Map<String, String> errors;
}
