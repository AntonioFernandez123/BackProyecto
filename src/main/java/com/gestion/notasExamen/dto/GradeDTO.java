package com.gestion.notasExamen.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GradeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idGrade;
    private String name;
    private String shortName;
    private TeacherDTO teacher;

}
