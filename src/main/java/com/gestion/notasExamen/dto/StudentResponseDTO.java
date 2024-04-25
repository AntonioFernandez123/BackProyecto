package com.gestion.notasExamen.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudentResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idStudent;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private int nre;
    private String dni;

}
