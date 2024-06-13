package com.gestion.notasExamen.repository;


import com.gestion.notasExamen.entity.Exam_StudentEntity;
import com.gestion.notasExamen.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Exam_StudentRepository extends JpaRepository<Exam_StudentEntity,Long> {

  @Query("SELECT e FROM Exam_StudentEntity e WHERE e.exam.idExam = :examId AND e.student.idUser = :studentId")
  Exam_StudentEntity findExamStudent(@Param("examId") Long examId, @Param("studentId") Long studentId);

  @Query("SELECT e FROM Exam_StudentEntity e WHERE e.exam.idExam = :examId ")
  List<Exam_StudentEntity> findAllWhitExamId(@Param("examId") Long examId);

}
