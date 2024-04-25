package com.gestion.notasExamen.mapper;

import java.util.List;

import com.gestion.notasExamen.dto.SubjectDTO;
import com.gestion.notasExamen.dto.SubjectResponseDTO;
import com.gestion.notasExamen.entity.SubjectEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO SubjectEntityToSubjectDTO(SubjectEntity subjectEntity);

    SubjectResponseDTO SubjectEntityToSubjectResponseDTO(SubjectEntity subjectEntity);

    SubjectEntity SubjectDTOToSubjectEntity(SubjectDTO subject);

    SubjectEntity SubjectResponseDTOToSubjectEntity(SubjectResponseDTO subject);

    List<SubjectDTO> SubjectEntityListToSubjectDTOList(List<SubjectEntity> subjectEntityList);

}
