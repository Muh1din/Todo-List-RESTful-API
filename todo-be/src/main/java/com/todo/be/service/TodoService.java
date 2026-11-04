package com.todo.be.service;

import com.todo.be.dto.CreateTodoRequest;
import com.todo.be.entity.Todo;
import com.todo.be.exception.TodoNotFoundException;
import com.todo.be.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(CreateTodoRequest request) {
        Todo todo = new Todo();

        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());

        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id){
        Optional<Todo> todo = todoRepository.findById(id);

        return todo.orElseThrow(()-> new TodoNotFoundException(id));
    }
}
