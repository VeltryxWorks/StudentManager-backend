package com.veltryxworks.studentmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "todo")
public class ToDo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    @Getter private Long todoId;

    @Getter @Setter private String task;
    @Getter @Setter private LocalDate deadline;
    @Getter @Setter private boolean completed;
    @Getter @Setter private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter private Student student;

    public ToDo() {}

    public ToDo(String task, LocalDate deadline, boolean completed, Student student, TaskStatus status) {
        this.task = task;
        this.deadline = deadline;
        this.completed = completed;
        this.student = student;
        this.status = status;
    }

    public Object getTodo_id() {
        return todoId;
    }
}
