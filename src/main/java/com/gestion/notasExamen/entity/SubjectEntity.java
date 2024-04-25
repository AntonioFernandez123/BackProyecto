package com.gestion.notasExamen.entity;

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
@Table(name="Subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubject;

    @Column(name="name")
    private String name;

    @Column(name="shortName")
    private String shortName;

    @Column(name="hourPerWeek")
    private int hourPerWeek;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="grade", nullable = true)
    private GradeEntity grade;

    @ManyToMany(mappedBy = "subjects")
    private List<StudentEntity> students;

}
