package com.gestion.notasExamen.mapper;

import java.util.List;

import com.gestion.notasExamen.dto.TeacherDTO;
import com.gestion.notasExamen.entity.TeacherEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TeacherMapper.class})
public interface TeacherMapper {

    TeacherDTO TeacherEntityToTeacherDTO(TeacherEntity teacherEntity);

    TeacherEntity TeacherDTOToTeacherEntity(TeacherDTO teacher);

    List<TeacherDTO> TeacherEntityListToTeacherDTOList (List<TeacherEntity> teacherEntityList);

}
