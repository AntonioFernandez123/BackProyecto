package com.gestion.notasExamen.controller;

import com.gestion.notasExamen.dto.LoginRequest;
import com.gestion.notasExamen.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/auth/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    return authService.login(request);
  }

}
