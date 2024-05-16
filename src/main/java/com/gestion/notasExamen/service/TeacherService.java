package com.gestion.notasExamen.service;

import java.util.List;

import com.gestion.notasExamen.dto.TeacherDTO;
import com.gestion.notasExamen.mapper.TeacherMapper;
import com.gestion.notasExamen.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherDTO> getAllTeachers(){
        return teacherMapper.TeacherEntityListToTeacherDTOList(teacherRepository.findAll());
    }

    public TeacherDTO getTeacherById(Long id) {
        return teacherMapper.TeacherEntityToTeacherDTO(teacherRepository.getReferenceById(id));
    }

    public void createTeacher(TeacherDTO teacher) {
        teacherRepository.save(teacherMapper.TeacherDTOToTeacherEntity(teacher));
    }

    public void updateTeacher(TeacherDTO teacher) {
        teacherRepository.save(teacherMapper.TeacherDTOToTeacherEntity(teacher));
    }

    public void deleteTeacher(Long id) {
        if(teacherRepository.getReferenceById(id) != null) {
            teacherRepository.deleteById(id);
        }
    }

}
