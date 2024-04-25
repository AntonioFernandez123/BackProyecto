package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.StudentEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
