package com.gestion.notasExamen.controller;

import java.math.BigDecimal;
import java.util.List;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.dto.Exam_StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.Exam_StudentEntity;
import com.gestion.notasExamen.service.ExamService;
import com.gestion.notasExamen.service.Exam_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {

    @Autowired
    private Exam_StudentService exam_studentService;

    @Autowired
    private ExamService examService;

    @GetMapping("/exam/getAllExams")
    public ResponseEntity<List<ExamDTO>> getAllExams(){
        return  ResponseEntity.status(HttpStatus.OK).body(examService.getAllExames());
    }

    @GetMapping("/exam/getExamById")
    public ResponseEntity<ExamDTO> getExamById(@RequestParam long idExam){
        return ResponseEntity.status(HttpStatus.OK).body(examService.getExamById(idExam));
    }

    @PostMapping("/exam/createExam")
    public ResponseEntity<ExamResponseDTO> createExam(@RequestBody ExamResponseDTO exam){
        return ResponseEntity.status(HttpStatus.CREATED).body( examService.createExam(exam));
    }

    @PutMapping("/exam/updateExam")
    public ResponseEntity<Void> updateExam(@RequestBody ExamDTO exam){
        examService.updateExam(exam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/exam/deleteExam")
    public ResponseEntity<Void> deleteExam(@RequestParam long idExam){
        examService.deleteExam(idExam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/exam/getAllExamsByIdSubject")
    public ResponseEntity<List<ExamDTO>> getAllExamsByIdSubject(@RequestParam long idSubject){
        return  ResponseEntity.status(HttpStatus.OK).body(examService.getAllExamsByIdSubject(idSubject));
    }

    @PatchMapping("/exam/addStudentsToExam")
    public ResponseEntity<Void> addStudentsToExam(@RequestBody List<StudentResponseDTO> students, @RequestParam Long idExam){
        exam_studentService.addStudentsToExam(students, idExam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/exam/addNoteToExam")
    public ResponseEntity<Void> addNoteToExam(@RequestBody Exam_StudentDTO exam_student){
        exam_studentService.addNoteToExam(exam_student.getStudent(),exam_student.getExam(),exam_student.getNote());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/exam/getAllStudentWithNote")
    public ResponseEntity<List<Exam_StudentDTO>> getAllStudentWithNote(){
        return ResponseEntity.status(HttpStatus.OK).body( exam_studentService.getAllStudentWithNote());
    }

    @GetMapping("/exam/getAllExamsByIdStudent")
    public ResponseEntity<List<Exam_StudentDTO>> getAllExamsByIdStudent(@RequestParam Long idStudent){
        return ResponseEntity.status(HttpStatus.OK).body( examService.getAllExamsByIdStudent(idStudent));
    }


}
