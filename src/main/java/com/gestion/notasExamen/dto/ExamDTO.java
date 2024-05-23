package com.gestion.notasExamen.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private long idExam;
    private String themes;
    private String description;
    private LocalDate date;
    private LocalDateTime hour;
    private SubjectResponseDTO subject;
    private List<StudentResponseDTO> students;

}
