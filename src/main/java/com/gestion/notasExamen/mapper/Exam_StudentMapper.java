package com.gestion.notasExamen.mapper;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.Exam_StudentDTO;
import com.gestion.notasExamen.entity.ExamEntity;
import com.gestion.notasExamen.entity.Exam_StudentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Exam_StudentMapper {

  List<Exam_StudentDTO> Exam_StudentEntityListToExam_StudentDTOList (List<Exam_StudentEntity> examStudentEntityList);

}
