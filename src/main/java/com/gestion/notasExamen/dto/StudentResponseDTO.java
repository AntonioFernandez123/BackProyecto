package com.gestion.notasExamen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class StudentResponseDTO extends UserDTO {

  @Builder
  public StudentResponseDTO(Long idUser, String name, String lastName, String password, String email, String userName, String dni, Role role) {
    super(idUser, name, lastName, password, email, userName, dni, role);
  }
}
