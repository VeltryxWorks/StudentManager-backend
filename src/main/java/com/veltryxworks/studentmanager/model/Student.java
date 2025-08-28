package com.veltryxworks.studentmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    @Getter Long studentId;

    @Getter @Setter private String name;
    @Getter @Setter private String surname;
    @Getter @Setter private String email;

    // Relazione con Exam (uno studente può avere tanti esami)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> exams = new ArrayList<>();

    // Relazione con ToDo (uno studente può avere tanti task)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ToDo> todos = new ArrayList<>();

    public Student() {}

    // Costruttore utile
    public Student(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Metodi helper per mantenere relazioni consistenti
    public void addExam(Exam exam) {
        exams.add(exam);
        exam.setStudent(this);
    }

    public void removeExam(Exam exam) {
        exams.remove(exam);
        exam.setStudent(null);
    }

    public void addToDo(ToDo todo) {
        todos.add(todo);
        todo.setStudent(this);
    }

    public void removeToDo(ToDo todo) {
        todos.remove(todo);
        todo.setStudent(null);
    }
}
