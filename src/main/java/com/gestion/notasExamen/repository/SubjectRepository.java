package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.SubjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
