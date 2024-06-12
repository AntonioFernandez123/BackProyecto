package com.gestion.notasExamen.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private String date;

    @Column(name="hour")
    private String hour;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="subject", nullable = true)
    private SubjectEntity subject;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam_StudentEntity> examStudents;

}
