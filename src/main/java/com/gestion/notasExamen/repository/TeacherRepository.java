package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {
}
