package com.gestion.notasExamen.controller;

import java.util.List;

import com.gestion.notasExamen.dto.TeacherDTO;
import com.gestion.notasExamen.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/getAllTeachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }

    @GetMapping("/teacher/getTeacherById")
    public ResponseEntity<TeacherDTO> getTeacherById(@RequestParam long idTeacher) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacherById(idTeacher));
    }

    @PostMapping("/teacher/createTeacher")
    public ResponseEntity<Void> createTeacher(@RequestBody TeacherDTO teacher) {
        teacherService.createTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/teacher/updateTeacher")
    public ResponseEntity<Void> updateTeacher(@RequestBody TeacherDTO teacher) {
        teacherService.updateTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/teacher/deleteTeacher")
    public ResponseEntity<Void> deleteTeacher(@RequestParam long idTeacher) {
        teacherService.deleteTeacher(idTeacher);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
