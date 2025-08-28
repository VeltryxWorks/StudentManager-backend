package com.veltryxworks.studentmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entity Exam
 * Rappresenta gli esami che bisogna sostenere
 */
@Entity
@Table(name = "exam")
public class Exam implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    @Getter private Long examId;

    @Getter @Setter private String title;
    @Getter @Setter private String description;
    @Getter @Setter private LocalDate examDate;
    @Getter @Setter private Integer vote;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private ExamStatus status;

    @ManyToOne(fetch = FetchType.LAZY) // lazy per ottimizzare query
    @JoinColumn(name = "student_id", nullable = false)
    @Getter @Setter private Student student;

    public Exam() {}

    public Exam(String title, String description, LocalDate examDate, Integer vote, ExamStatus status, Student student) {
        this.title = title;
        this.description = description;
        this.examDate = examDate;
        this.vote = vote;
        this.status = status;
        this.student = student;
    }

}
