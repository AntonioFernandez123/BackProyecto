package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.StudentEntity;

import com.gestion.notasExamen.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

  Optional<StudentEntity> findByUserName (String userName);

}
