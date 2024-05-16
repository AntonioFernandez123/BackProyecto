package com.gestion.notasExamen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentResponseDTO extends UserDTO {

  private long idStudent;

  @Builder
  public StudentResponseDTO(String name, String lastName, String password, String email, String userName, String dni, long idStudent) {
    super(name, lastName, password, email, userName, dni);
    this.idStudent = idStudent;
  }
}
