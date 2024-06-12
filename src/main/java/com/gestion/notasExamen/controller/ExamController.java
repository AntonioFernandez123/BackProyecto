package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
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
    public ResponseEntity<Void> updateExam(@RequestBody ExamResponseDTO exam){
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

}
