package com.veltryxworks.studentmanager.controller;

import com.veltryxworks.studentmanager.model.Exam;
import com.veltryxworks.studentmanager.repository.ExamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamRepository examRepository;

    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam exam) {
        return examRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(exam.getTitle());
                    existing.setDescription(exam.getDescription());
                    existing.setExamDate(exam.getExamDate());
                    existing.setVote(exam.getVote());
                    existing.setStatus(exam.getStatus());
                    return ResponseEntity.ok(examRepository.save(existing));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
