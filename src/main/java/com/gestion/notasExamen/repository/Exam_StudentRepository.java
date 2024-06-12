package com.gestion.notasExamen.repository;


import com.gestion.notasExamen.entity.Exam_StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Exam_StudentRepository extends JpaRepository<Exam_StudentEntity,Long> {
}
