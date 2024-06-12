package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.StudentEntity;

import com.gestion.notasExamen.entity.SubjectEntity;
import com.gestion.notasExamen.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

  Optional<StudentEntity> findByUserName (String userName);

  @Query("SELECT s FROM StudentEntity s JOIN s.subjects subj WHERE subj.idSubject = :subjectId")
  List<StudentEntity> findAllBySubjectId(@Param("subjectId") Long subjectId);


}
