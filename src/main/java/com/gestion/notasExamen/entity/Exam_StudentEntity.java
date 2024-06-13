package com.gestion.notasExamen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="exam_student")
public class Exam_StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idExamStudent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "exam_id", referencedColumnName = "idExam", nullable = false)
  private ExamEntity exam;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id", referencedColumnName = "idUser", nullable = false)
  private StudentEntity student;

  @Column(name="note")
  private BigDecimal note;


}
