package com.gestion.notasExamen.repository;

import com.gestion.notasExamen.entity.ExamEntity;
import com.gestion.notasExamen.entity.Student_SubjectEntity;
import com.gestion.notasExamen.entity.Student_SubjectEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_SubjectRepository extends JpaRepository<Student_SubjectEntity, Student_SubjectEntityId> {
}
