package com.gestion.notasExamen.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TeacherDTO extends UserDTO {

  @Builder
  public TeacherDTO(Long idUser, String name, String lastName, String password, String email, String userName, String dni) {
    super(idUser, name, lastName, password, email, userName, dni);
  }
}
