package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.GradeDTO;
import com.gestion.notasExamen.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/grade/getAllGrades")
    public ResponseEntity<List<GradeDTO>> getAllGrades(){
        return  ResponseEntity.status(HttpStatus.OK).body(gradeService.getAllGrades());
    }

    @GetMapping("/grade/getGradeById")
    public ResponseEntity<GradeDTO> getGradeById(@RequestParam long idGrade){
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getGradeById(idGrade));
    }

    @PostMapping("/grade/createGrade")
    public ResponseEntity<Void> createGrade(@RequestBody GradeDTO grade){
        gradeService.createGrade(grade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/grade/updateGrade")
    public ResponseEntity<Void> updateGrade(@RequestBody GradeDTO grade){
        gradeService.updateGrade(grade);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/grade/deleteGrade")
    public ResponseEntity<Void> deleteGrade(@RequestParam long idGrade){
        gradeService.deleteGrade(idGrade);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
