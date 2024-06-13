package com.gestion.notasExamen.service;

import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.dto.Exam_StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.ExamEntity;
import com.gestion.notasExamen.entity.Exam_StudentEntity;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.SubjectEntity;
import com.gestion.notasExamen.mapper.Exam_StudentMapper;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.repository.ExamRepository;
import com.gestion.notasExamen.repository.Exam_StudentRepository;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

  @Autowired
  private Exam_StudentMapper exam_studentMapper;

  public List<Exam_StudentDTO> getAllStudentWithNote (){
    return exam_studentMapper.Exam_StudentEntityListToExam_StudentDTOList(exam_studentRepository.findAll());
  }

  public void addStudentsToExam(List<StudentResponseDTO> students, Long idExam) {
    ExamEntity exam = examRepository.getReferenceById(idExam);

    if (exam != null) {
      for (StudentResponseDTO student : students) {
        StudentEntity alu = studentRepository.findById(student.getIdUser()).get();

        Exam_StudentEntity examStudent = new Exam_StudentEntity();

        examStudent.setExam(exam);
        examStudent.setStudent(alu);
        examStudent.setNote(BigDecimal.valueOf(0));
        exam_studentRepository.save(examStudent);
      }
    }
  }

  public void addNoteToExam (StudentResponseDTO student, ExamResponseDTO exam, BigDecimal nota){
    ExamEntity examen = examRepository.getReferenceById(exam.getIdExam());
    StudentEntity stu = studentRepository.getReferenceById(student.getIdUser());

    if (examen != null && stu != null){

      Exam_StudentEntity examStudent = exam_studentRepository.findExamStudent(exam.getIdExam(), student.getIdUser());

      examStudent.setNote(nota);
      exam_studentRepository.save(examStudent);
    }
  }

  public List<Exam_StudentDTO> findAllWithIdExam(long idExam){
    if (examRepository.existsById(idExam)){
      return exam_studentMapper.Exam_StudentEntityListToExam_StudentDTOList(exam_studentRepository.findAllWhitExamId(idExam));
    }
    return null;
  }
}
