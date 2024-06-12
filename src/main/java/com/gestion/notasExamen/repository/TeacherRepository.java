package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Long> {

  Optional<TeacherEntity> findByUserName (String userName);

}
