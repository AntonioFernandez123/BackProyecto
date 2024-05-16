package com.gestion.notasExamen.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO extends UserDTO {

    private List<SubjectResponseDTO> subjects;
    private List<ExamResponseDTO> exams;

}
