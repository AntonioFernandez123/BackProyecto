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
public class StudentEntity extends UserEntity{

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
