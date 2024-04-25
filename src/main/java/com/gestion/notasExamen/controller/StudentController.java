package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.service.StudentService;
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
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("student/getStudentById")
    public ResponseEntity<StudentDTO> getStudentById(@RequestParam long idStudent){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(idStudent));
    }

    @PostMapping("student/createStudent")
    public ResponseEntity<Void> createStudent(@RequestBody StudentResponseDTO student){
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("student/updateStudent")
    public ResponseEntity<Void> updateStudent(@RequestBody StudentResponseDTO student){
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("student/deleteStudent")
    public ResponseEntity<Void> deleteStudent(@RequestParam long idStudent){
        studentService.deleteStudent(idStudent);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
