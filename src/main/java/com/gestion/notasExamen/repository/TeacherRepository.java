package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

  Optional<TeacherEntity> findByUserName (String userName);

}
