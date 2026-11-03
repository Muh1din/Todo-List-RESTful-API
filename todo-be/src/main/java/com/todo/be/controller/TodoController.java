package com.todo.be.controller;

import com.todo.be.dto.CreateTodoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @PostMapping("/preview")
    public CreateTodoRequest createTodoPreview(
            @RequestBody CreateTodoRequest request
    ) {
        return request;
    }
}
