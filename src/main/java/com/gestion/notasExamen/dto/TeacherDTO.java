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
public class TeacherDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long idTeacher;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String userName;
    private String dni;

}
