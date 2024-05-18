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
public class StudentDTO extends UserDTO {

    private List<SubjectResponseDTO> subjects;
    private List<ExamResponseDTO> exams;

    @Builder
    public StudentDTO(Long idUser, String name, String lastName, String password, String email, String userName, String dni, List<SubjectResponseDTO> subjects, List<ExamResponseDTO> exams) {
        super(idUser, name, lastName, password, email, userName, dni);
        this.subjects = subjects;
        this.exams = exams;
    }
}
