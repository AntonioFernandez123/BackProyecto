package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.SubjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

  @Query("SELECT s FROM SubjectEntity s WHERE s.grade.teacher.idUser = :teacherId and s.grade.idGrade = :gradeId")
  List<SubjectEntity> findAllByTeacherAndGradeId(@Param("teacherId") Long teacherId, @Param("gradeId") Long gradeId);


}
