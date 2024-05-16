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

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idStudent;

  @Builder
  public StudentEntity(String name, String lastName, String userName, String password, String email, String dni, long idStudent, List<ExamEntity> exams, List<SubjectEntity> subjects) {
    super(name, lastName, userName, password, email, dni);
    this.idStudent = idStudent;
    this.exams = exams;
    this.subjects = subjects;
  }

  @ManyToMany(mappedBy = "students1",
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
