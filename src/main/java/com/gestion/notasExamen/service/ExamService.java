package com.gestion.notasExamen.service;

import java.util.List;
import java.util.Optional;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.dto.Exam_StudentDTO;
import com.gestion.notasExamen.entity.ExamEntity;
import com.gestion.notasExamen.mapper.ExamMapper;
import com.gestion.notasExamen.mapper.Exam_StudentMapper;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.mapper.SubjectMapper;
import com.gestion.notasExamen.repository.ExamRepository;
import com.gestion.notasExamen.repository.Exam_StudentRepository;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private Exam_StudentMapper exam_studentMapper;

    @Autowired
    private Exam_StudentRepository exam_studentRepository;

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

    public void updateExam(ExamDTO exam) {
        examRepository.save(examMapper.ExamDTOToExamEntity(exam));
    }

//    public void updateExam(ExamDTO exam) {
//        Optional<ExamEntity> optionalExam = examRepository.findById(exam.getIdExam());
//
//        if (optionalExam.isPresent()){
//            ExamEntity exam1 = optionalExam.get();
//
//            exam1.setIdExam(exam.getIdExam());
//            exam1.setExamStudents(studentMapper.StudentDTOListToStudentEntityList(exam.getStudents()));
//            exam1.setDate();
//            exam1.setHour();
//            exam1.setDescription();
//            exam1.setThemes();
//            exam1.setSubject(subjectMapper.SubjectDTOToSubjectEntity(exam.getSubject()));
//        }
//
//        examRepository.save(examMapper.ExamResponseDTOToExamEntity(exam));
//    }


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

    public List<Exam_StudentDTO> getAllExamsByIdStudent (Long idStudent){
        if (studentRepository.existsById(idStudent)){
            return exam_studentMapper.Exam_StudentEntityListToExam_StudentDTOList(exam_studentRepository.findAllWhitStudentId(idStudent));
        }
        return null;
    }

}
