package com.gestion.notasExamen.security;


import com.gestion.notasExamen.entity.StudentEntity;
import com.gestion.notasExamen.entity.TeacherEntity;
import com.gestion.notasExamen.entity.UserEntity;
import com.gestion.notasExamen.mapper.UserMapper;
import com.gestion.notasExamen.repository.StudentRepository;
import com.gestion.notasExamen.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

  private String TOKEN;

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private UserMapper userMapper;

  private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public ResponseEntity<LoginResponseDTO> login(LoginRequest request) {

    UserEntity reqUserEntity = userMapper.userEntityToAuthRequest(request);
    String user = reqUserEntity.getUserName();
    String pass = reqUserEntity.getPassword();

    Optional<StudentEntity> student = studentRepository.findByUserName(user);
    if (student.isPresent() && passwordEncoder.matches(pass, student.get().getPassword())){
      LoginResponseDTO login = new LoginResponseDTO();
      login.setToken(Long.toString(student.get().getIdUser()));
      login.setRole(student.get().getRole());
      return ResponseEntity.ok(login);
    }

    Optional<TeacherEntity> teacher = teacherRepository.findByUserName(user);
    if(teacher.isPresent() && passwordEncoder.matches(pass, teacher.get().getPassword())){
      LoginResponseDTO login = new LoginResponseDTO();
      login.setToken(Long.toString(teacher.get().getIdUser()));
      login.setRole(teacher.get().getRole());
      return ResponseEntity.ok(login);
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }
}
