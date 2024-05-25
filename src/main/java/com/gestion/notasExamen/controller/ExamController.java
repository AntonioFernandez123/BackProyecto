package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.ExamDTO;
import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/exam/getAllExames")
    public ResponseEntity<List<ExamDTO>> getAllExames(){
        return  ResponseEntity.status(HttpStatus.OK).body(examService.getAllExames());
    }

    @GetMapping("/exam/getExamById")
    public ResponseEntity<ExamDTO> getExamById(@RequestParam long idExam){
        return ResponseEntity.status(HttpStatus.OK).body(examService.getExamById(idExam));
    }

    @PostMapping("/exam/createExam")
    public ResponseEntity<Void> createExam(@RequestBody ExamResponseDTO exam){
        examService.createExam(exam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/exam/updateExam")
    public ResponseEntity<Void> updateExam(@RequestBody ExamResponseDTO exam){
        examService.updateExam(exam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/exam/deleteExam")
    public ResponseEntity<Void> deleteExam(@RequestParam long idExam){
        examService.deleteExam(idExam);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
