package com.gestion.notasExamen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam_StudentDTO implements Serializable {

  private ExamResponseDTO exam;
  private StudentResponseDTO student;
  private BigDecimal note;

}
