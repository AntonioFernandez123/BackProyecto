package com.gestion.notasExamen.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name="Exam")
public class ExamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExam;

    @Column(name="themes")
    private String themes;

    @Column(name="description")
    private String description;

    @Column(name="date")
    private LocalDate date;

    @Column(name="hour")
    private LocalDateTime hour;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="subject", nullable = true)
    private SubjectEntity subject;

    @ManyToMany(mappedBy = "exams")
    private List<StudentEntity> students;

}
