package com.gestion.notasExamen.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_subject", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "idStudent", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "idSubject", nullable = true)
    )
    private List<SubjectEntity> subjects;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_exam", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "idStudent", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "exam_id", referencedColumnName = "idExam", nullable = true)
    )
    private List<ExamEntity> exams;

}
