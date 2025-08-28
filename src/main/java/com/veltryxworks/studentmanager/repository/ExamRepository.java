package com.veltryxworks.studentmanager.repository;

import com.veltryxworks.studentmanager.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository auto implementa
 * findAll() → recupera tutti i record
 * findById(Long id) → recupera un record per ID
 * save(ToDo todo) → inserisce o aggiorna
 * deleteById(Long id) → cancella per ID
 * count() → conta i record
 */
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
