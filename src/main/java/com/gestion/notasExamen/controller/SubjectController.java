package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.dto.SubjectDTO;
import com.gestion.notasExamen.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject/getAllSubjects")
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
        return  ResponseEntity.status(HttpStatus.OK).body(subjectService.getAllSubjects());
    }

    @GetMapping("/subject/getSubjectById")
    public ResponseEntity<SubjectDTO> getSubjectById(@RequestParam long idSubject){
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectById(idSubject));
    }

    @PostMapping("/subject/createSubject")
    public ResponseEntity<Void> createSubject(@RequestBody SubjectDTO subject){
        subjectService.createSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/subject/updateSubject")
    public ResponseEntity<Void> updateSubject(@RequestBody SubjectDTO subject){
        subjectService.updateSubject(subject);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/subject/deleteSubject")
    public ResponseEntity<Void> deleteSubject(@RequestParam long idSubject){
        subjectService.deleteSubject(idSubject);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/subject/getAllSubjectsWithTeacherAndGradeId")
    public ResponseEntity<List<SubjectDTO>> getAllSubjectsWithTeacherAndGradeId(@RequestParam long idTeacher,
                                                                                @RequestParam long idGrade){
        return  ResponseEntity.status(HttpStatus.OK).body(subjectService.getAllSubjectsWithTeacherAndGradeId(idTeacher, idGrade));
    }

    @GetMapping("/subject/getAllSubjectsWithStudentId")
    public ResponseEntity<List<SubjectDTO>> getAllSubjectsWithStudentId(@RequestParam long idStudent){
        return  ResponseEntity.status(HttpStatus.OK).body(subjectService.getAllSubjectsWithStudentId(idStudent));
    }

    @PatchMapping("/subject/addStudent")
    public ResponseEntity<Void> addStudentsToSubject(@RequestBody List<StudentResponseDTO> students, @RequestParam Long idSubject){
        subjectService.addStudentsToSubject(students, idSubject);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
