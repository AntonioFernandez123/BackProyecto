package com.gestion.notasExamen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="Teacher")
public class TeacherEntity extends UserEntity{

  @Builder
  public TeacherEntity(long idUser, String name, String lastName, String userName, String password, String email, String dni) {
    super(idUser, name, lastName, userName, password, email, dni);
  }
}
