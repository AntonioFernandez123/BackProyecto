package com.gestion.notasExamen.service;

import java.util.List;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.mapper.ExamMapper;
import com.gestion.notasExamen.repository.ExamRepository;
import com.gestion.notasExamen.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private ExamRepository examRepository;

    public List<ExamDTO> getAllExames(){
        return examMapper.ExamEntityListToExamDTOList(examRepository.findAll());
    }

    public ExamDTO getExamById(Long id) {
        return examMapper.ExamEntityToExamDTO(examRepository.getReferenceById(id));
    }

    public ExamResponseDTO createExam(ExamResponseDTO exam) {
        var examEntity = examRepository.save(examMapper.ExamResponseDTOToExamEntity(exam));
        exam.setIdExam(examEntity.getIdExam());
        return exam;
    }

    public void updateExam(ExamResponseDTO exam) {
        examRepository.save(examMapper.ExamResponseDTOToExamEntity(exam));
    }

    public void deleteExam(Long id) {
        if(examRepository.getReferenceById(id) != null) {
            examRepository.deleteById(id);
        }
    }

    public List<ExamDTO> getAllExamsByIdSubject (Long idSubject) {
        if (subjectRepository.existsById(idSubject)){
            return examMapper.ExamEntityListToExamDTOList(examRepository.findAllBySubjectId(idSubject));
        }
        return null;
    }

}
