package com.gestion.notasExamen.mapper;

import java.util.List;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.entity.ExamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class, StudentMapper.class})
public interface ExamMapper {

    ExamDTO ExamEntityToExamDTO(ExamEntity examEntity);

    ExamResponseDTO ExamEntityToExamResponseDTO(ExamEntity examEntity);

    ExamEntity ExamDTOToExamEntity(ExamDTO exam);

    ExamEntity ExamResponseDTOToExamEntity(ExamResponseDTO exam);

    List<ExamDTO> ExamEntityListToExamDTOList (List<ExamEntity> examEntityList);

}
