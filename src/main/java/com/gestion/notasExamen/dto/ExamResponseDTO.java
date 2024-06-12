package com.gestion.notasExamen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamResponseDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private long idExam;
    private String themes;
    private String description;
    private String date;
    private String hour;
    private SubjectResponseDTO subject;

}
