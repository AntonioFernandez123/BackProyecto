package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.ExamEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamEntity, Long> {
}
