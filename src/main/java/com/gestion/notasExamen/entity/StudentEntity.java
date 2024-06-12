package com.gestion.notasExamen.entity;

import java.util.List;

import com.gestion.notasExamen.dto.Role;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.dto.SubjectResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class StudentEntity extends UserEntity {

  @Builder
  public StudentEntity(long idUser, String name, String lastName, String userName, String password, String email, String dni, Role role, List<SubjectEntity> subjects, List<Exam_StudentEntity> examStudents) {
    super(idUser, name, lastName, userName, password, email, dni, role);
    this.subjects = subjects;
    this.examStudents = examStudents;
  }

  @ManyToMany(mappedBy = "students",
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE,
          CascadeType.REMOVE
      })
  private List<SubjectEntity> subjects;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Exam_StudentEntity> examStudents;

}
