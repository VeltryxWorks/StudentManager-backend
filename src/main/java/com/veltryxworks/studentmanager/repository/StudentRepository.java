package com.veltryxworks.studentmanager.repository;

import com.veltryxworks.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
