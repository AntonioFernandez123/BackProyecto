package com.gestion.notasExamen.service;

import java.util.List;

import com.gestion.notasExamen.dto.GradeDTO;
import com.gestion.notasExamen.mapper.GradeMapper;
import com.gestion.notasExamen.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private GradeRepository gradeRepository;

    public List<GradeDTO> getAllGrades(){
        return gradeMapper.GradeEntityListToGradeDTOList(gradeRepository.findAll());
    }

    public GradeDTO getGradeById(Long id) {
        return gradeMapper.GradeEntityToGraderDTO(gradeRepository.getReferenceById(id));
    }

    public void createGrade(GradeDTO grade) {
        gradeRepository.save(gradeMapper.GradeDTOToGradeEntity(grade));
    }

    public void updateGrade(GradeDTO grade) {
        gradeRepository.save(gradeMapper.GradeDTOToGradeEntity(grade));
    }

    public void deleteGrade(Long id) {
        if(gradeRepository.getReferenceById(id) != null) {
            gradeRepository.deleteById(id);
        }
    }

}
