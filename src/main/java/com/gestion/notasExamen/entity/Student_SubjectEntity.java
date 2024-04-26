package com.gestion.notasExamen.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
@Table(name="student_subject")
public class Student_SubjectEntity {

    @EmbeddedId
    private Student_SubjectEntityId studentSubjectEntityId;

}
