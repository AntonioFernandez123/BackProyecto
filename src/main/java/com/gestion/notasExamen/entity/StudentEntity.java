package com.gestion.notasExamen.entity;

import java.util.List;

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
@Table(name="Student")
public class StudentEntity extends UserEntity{

  @Builder
  public StudentEntity(long idUser, String name, String lastName, String userName, String password, String email, String dni, List<SubjectEntity> subjects, List<ExamEntity> exams) {
    super(idUser, name, lastName, userName, password, email, dni);
    this.subjects = subjects;
    this.exams = exams;
  }

  @ManyToMany(mappedBy = "students",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "students",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<ExamEntity> exams;

}
