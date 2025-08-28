package com.veltryxworks.studentmanager.service;

import com.veltryxworks.studentmanager.model.ToDo;
import com.veltryxworks.studentmanager.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Chiama i repository per leggere/scrivere sul DB.
 * Mantiene la logica centralizzata (se cambio regole, cambio qui, non nel controller).
 */
@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}
