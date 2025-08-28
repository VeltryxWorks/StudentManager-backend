package com.veltryxworks.studentmanager.service;

import com.veltryxworks.studentmanager.model.Exam;
import com.veltryxworks.studentmanager.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    public Exam save(Exam exam) {
        return examRepository.save(exam);
    }

    public void delete(Long id) {
        examRepository.deleteById(id);
    }

}
