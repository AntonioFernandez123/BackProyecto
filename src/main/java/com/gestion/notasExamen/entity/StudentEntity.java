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
@Builder
@Entity
@Table(name="Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStudent;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="nre")
    private int nre;

    @Column(name="dni")
    private String dni;

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
