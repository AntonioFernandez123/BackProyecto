package com.gestion.notasExamen.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.gestion.notasExamen.dto.ExamResponseDTO;
import com.gestion.notasExamen.dto.Exam_StudentDTO;
import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.service.Exam_StudentService;
import com.gestion.notasExamen.service.StudentService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    private Exam_StudentService exam_studentService;

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

    @GetMapping("student/findAllWithIdExam")
    public void findAllWithIdExam (@RequestParam long idExam, HttpServletResponse response) throws Exception{

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=notas.csv");

        List<Exam_StudentDTO> list = exam_studentService.findAllWithIdExam(idExam);

        try(PrintWriter writer = response.getWriter();
        CSVWriter csvWriter = new CSVWriter(writer)){
            String[] header = {"Descripcion","Temas","Nombre Alumno","NRE","Nota"};
            csvWriter.writeNext(header);

            for (Exam_StudentDTO examStudent : list){
                String[] data = {
                    examStudent.getExam().getDescription(),
                    examStudent.getExam().getThemes(),
                    examStudent.getStudent().getName(),
                    examStudent.getStudent().getUserName(),
                    String.valueOf(examStudent.getNote())
                };
                csvWriter.writeNext(data);
            }
        }
    }

}
