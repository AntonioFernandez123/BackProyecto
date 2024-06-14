package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.GradeEntity;

import com.gestion.notasExamen.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

  @Query("SELECT s FROM GradeEntity s WHERE s.teacher.idUser = :teacherId")
  List<GradeEntity> findAllByTeacherId(@Param("teacherId") Long teacherId);



}
