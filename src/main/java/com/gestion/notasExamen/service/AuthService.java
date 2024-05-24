package com.gestion.notasExamen.service;


import com.gestion.notasExamen.dto.LoginRequest;
import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.TeacherEntity;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AuthService {

  private String TOKEN;

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private StudentRepository studentRepository;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public ResponseEntity<String> login(LoginRequest request) {

    String user = request.getUserName();
    String pass = request.getPassword();

    Optional<StudentEntity> student = studentRepository.findByUserName(user);
    if (student.isPresent() && passwordEncoder.matches(pass, student.get().getPassword())){
      this.TOKEN = Long.toString(student.get().getIdUser());
      return ResponseEntity.ok(TOKEN);
    }

    Optional<TeacherEntity> teacher = teacherRepository.findByUserName(user);
    if(teacher.isPresent() && passwordEncoder.matches(pass, teacher.get().getPassword())){
      this.TOKEN = Long.toString(student.get().getIdUser());
      return ResponseEntity.ok(TOKEN);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña Incorrectos");
  }
}
