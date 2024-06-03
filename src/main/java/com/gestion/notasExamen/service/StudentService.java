package com.gestion.notasExamen.service;

import java.util.List;

import com.gestion.notasExamen.dto.StudentDTO;
import com.gestion.notasExamen.dto.StudentResponseDTO;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.mapper.StudentMapper;
import com.gestion.notasExamen.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder pass;

    public List<StudentDTO> getAllStudents(){
        return studentMapper.StudentEntityListToStudentDTOList(studentRepository.findAll());
    }

    public StudentDTO getStudentById(Long id) {
        return studentMapper.StudentEntityToStudentDTO(studentRepository.getReferenceById(id));
    }

    public void createStudent(StudentResponseDTO student) {

        StudentEntity stu = studentMapper.StudentResponseDTOToStudentEntity(student);

        String passEncoder = pass.encode(stu.getPassword());
        stu.setPassword(passEncoder);

        studentRepository.save(stu);
    }

    public void updateStudent(StudentResponseDTO student) {
        studentRepository.save(studentMapper.StudentResponseDTOToStudentEntity(student));
    }

    public void deleteStudent(Long id) {
        if(studentRepository.getReferenceById(id) != null) {
            studentRepository.deleteById(id);
        }
    }

}
