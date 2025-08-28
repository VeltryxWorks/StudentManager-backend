package com.veltryxworks.studentmanager.controller;

import com.veltryxworks.studentmanager.model.ToDo;
import com.veltryxworks.studentmanager.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoService.findAll();
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo) {
        return toDoService.save(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateTodo(@PathVariable Long id, @RequestBody ToDo todo) {
        return toDoService.findAll().stream()
                .filter(t -> t.getTodo_id().equals(id))
                .findFirst()
                .map(existing -> {
                    existing.setTask(todo.getTask());
                    existing.setDeadline(todo.getDeadline());
                    existing.setCompleted(todo.isCompleted());
                    return ResponseEntity.ok(toDoService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
