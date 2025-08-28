package com.veltryxworks.studentmanager.controller;

import com.veltryxworks.studentmanager.model.Exam;
import com.veltryxworks.studentmanager.repository.ExamRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// DTO per restituire solo i campi necessari
@Setter
@Getter
class ExamDTO {
    // getter e setter
    private Long id;
    private String title;
    private String description;
    private String examDate;
    private Integer vote;
    private String status;
    private String studentName;

    public ExamDTO(Exam exam) {
        this.id = exam.getExamId();
        this.title = exam.getTitle();
        this.description = exam.getDescription();
        this.examDate = exam.getExamDate().toString();
        this.vote = exam.getVote();
        this.status = String.valueOf(exam.getStatus());
        this.studentName = exam.getStudent() != null ? exam.getStudent().getName() : null;
    }

}

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamRepository examRepository;

    public ExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public List<ExamDTO> getAllExams() {
        return examRepository.findAll()
                .stream()
                .map(ExamDTO::new)
                .collect(Collectors.toList());
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
                    existing.setStudent(exam.getStudent());
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
