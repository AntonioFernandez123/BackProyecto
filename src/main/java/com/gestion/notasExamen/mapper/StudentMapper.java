package com.gestion.notasExamen.mapper;

import java.util.List;

import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.StudentEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO StudentEntityToStudentDTO(StudentEntity studentEntity);

    StudentResponseDTO StudentEntityToStudentResponseDTO(StudentEntity studentEntity);

    StudentEntity StudentDTOToStudentEntity(StudentDTO student);

    StudentEntity StudentResponseDTOToStudentEntity(StudentResponseDTO student);

    List<StudentDTO> StudentEntityListToStudentDTOList (List<StudentEntity> studentEntityList);

}
