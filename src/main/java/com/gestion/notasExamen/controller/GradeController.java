package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.GradeDTO;
import com.gestion.notasExamen.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("grade/getAllGrades")
    public ResponseEntity<List<GradeDTO>> getAllGrades(){
        return  ResponseEntity.status(HttpStatus.OK).body(gradeService.getAllGrades());
    }

    @GetMapping("grade/getGradeById")
    public ResponseEntity<GradeDTO> getGradeById(@RequestParam long idGrade){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getGradeById(idGrade));
    }

    @PostMapping("grade/createGrade")
    public ResponseEntity<Void> createGrade(@RequestBody GradeDTO grade){
        gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("grade/updateGrade")
    public ResponseEntity<Void> updateGrade(@RequestBody GradeDTO grade){
        gradeService.updateGrade(grade);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("grade/deleteGrade")
    public ResponseEntity<Void> deleteGrade(@RequestParam long idGrade){
        gradeService.deleteGrade(idGrade);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
