package com.gestion.notasExamen.mapper;

import java.util.List;

import com.gestion.notasExamen.dto.GradeDTO;
import com.gestion.notasExamen.entity.GradeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {TeacherMapper.class, SubjectMapper.class})
public interface GradeMapper {

    GradeDTO GradeEntityToGraderDTO(GradeEntity gradeEntity);

    GradeEntity GradeDTOToGradeEntity(GradeDTO grade);

    List<GradeDTO> GradeEntityListToGradeDTOList (List<GradeEntity> gradeEntityList);
    
}
