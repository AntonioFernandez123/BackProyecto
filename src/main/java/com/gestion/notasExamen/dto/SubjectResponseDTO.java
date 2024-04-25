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
public class SubjectResponseDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private long idSubject;
    private String name;
    private String shortName;
    private int hourPerWeek;
    private GradeDTO grade;

}
