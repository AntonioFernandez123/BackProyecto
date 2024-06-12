package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.ExamEntity;

import com.gestion.notasExamen.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Long> {

  @Query("SELECT e FROM ExamEntity e WHERE e.subject.idSubject = :subjectId")
  List<ExamEntity> findAllBySubjectId(@Param("subjectId") Long subjectId);

}
