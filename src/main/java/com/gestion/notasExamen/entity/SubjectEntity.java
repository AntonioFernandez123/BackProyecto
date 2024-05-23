package com.gestion.notasExamen.entity;

import java.util.List;

import com.gestion.notasExamen.dto.StudentResponseDTO;
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
@Table(name="Subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSubject;

    @Column(name="name")
    private String name;

    @Column(name="short_name")
    private String shortName;

    @Column(name="hour_per_week")
    private int hourPerWeek;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="grade", nullable = true)
    private GradeEntity grade;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "subject_student", joinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "idSubject", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "idUser", nullable = true)
    )
    private List<StudentEntity> students;
}
