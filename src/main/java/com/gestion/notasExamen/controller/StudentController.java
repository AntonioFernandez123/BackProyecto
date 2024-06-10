package com.gestion.notasExamen.controller;

import java.io.IOException;
import java.util.List;

import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/student/getStudentById")
    public ResponseEntity<StudentDTO> getStudentById(@RequestParam long idStudent){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(idStudent));
    }

    @PostMapping("/student/createStudent")
    public ResponseEntity<Void> createStudent(@RequestBody StudentResponseDTO student){
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/student/createStudentCSV", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> createStudentCSV(@RequestPart("file")MultipartFile file) throws IOException {
        return ResponseEntity.ok(studentService.createStudentCSV(file));
    }

    @PutMapping("/student/updateStudent")
    public ResponseEntity<Void> updateStudent(@RequestBody StudentResponseDTO student){
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/student/deleteStudent")
    public ResponseEntity<Void> deleteStudent(@RequestParam long idStudent){
        studentService.deleteStudent(idStudent);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/student/getAllStudentInSubject")
    public ResponseEntity<List<StudentDTO>> getAllStudentInSubject(@RequestParam long idSubject){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentInSubject(idSubject));
    }

}
