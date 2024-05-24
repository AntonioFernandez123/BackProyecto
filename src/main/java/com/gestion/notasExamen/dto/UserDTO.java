package com.gestion.notasExamen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUser;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String userName;
    private String dni;
    private Role role;

}
