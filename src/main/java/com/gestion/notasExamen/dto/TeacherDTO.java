package com.gestion.notasExamen.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TeacherDTO extends UserDTO {

  private long idTeacher;

  @Builder
  public TeacherDTO(String name, String lastName, String password, String email, String userName, String dni, long idTeacher) {
    super(name, lastName, password, email, userName, dni);
    this.idTeacher = idTeacher;
  }

}
