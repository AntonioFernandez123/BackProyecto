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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Teacher")
public class TeacherEntity extends UserEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idTeacher;

  @Builder
  public TeacherEntity(String name, String lastName, String userName, String password, String email, String dni, long idTeacher) {
    super(name, lastName, userName, password, email, dni);
    this.idTeacher = idTeacher;
  }

}
