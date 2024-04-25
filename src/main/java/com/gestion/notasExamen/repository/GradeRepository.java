package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.GradeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
}
