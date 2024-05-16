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

    private long idStudent;
    private List<SubjectResponseDTO> subjects;
    private List<ExamResponseDTO> exams;

    @Builder
    public StudentDTO(String name, String lastName, String password, String email, String userName, String dni, List<SubjectResponseDTO> subjects, long idStudent, List<ExamResponseDTO> exams) {
        super(name, lastName, password, email, userName, dni);
        this.subjects = subjects;
        this.idStudent = idStudent;
        this.exams = exams;
    }
}
