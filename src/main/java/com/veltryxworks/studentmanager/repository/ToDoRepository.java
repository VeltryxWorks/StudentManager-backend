package com.veltryxworks.studentmanager.repository;

import com.veltryxworks.studentmanager.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository  extends JpaRepository<ToDo, Long>{
}
