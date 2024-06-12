package com.gestion.notasExamen.service;

import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.ExamEntity;
import com.gestion.notasExamen.entity.Exam_StudentEntity;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.SubjectEntity;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.repository.ExamRepository;
import com.gestion.notasExamen.repository.Exam_StudentRepository;
import com.gestion.notasExamen.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Exam_StudentService {

  @Autowired
  private Exam_StudentRepository exam_studentRepository;

  @Autowired
  private ExamRepository examRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentMapper studentMapper;

  public void addStudentsToExam(List<StudentResponseDTO> students, Long idExam) {
    ExamEntity exam = examRepository.getReferenceById(idExam);

    if (exam != null) {
      for (StudentResponseDTO student : students) {
        StudentEntity alu = studentRepository.findById(student.getIdUser()).get();

        Exam_StudentEntity examStudent = new Exam_StudentEntity();

        examStudent.setExam(exam);
        examStudent.setStudent(alu);
        exam_studentRepository.save(examStudent);
      }
    }
  }
}
