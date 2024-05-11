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
public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idStudent;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String userName;
    private String dni;
    private List<SubjectResponseDTO> subjects;
    private List<ExamResponseDTO> exams;

}
