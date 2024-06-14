package com.gestion.notasExamen.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

  private final AuthService authService;

  @PostMapping("auth/login")
  public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequest request) {
    return authService.login(request);
  }

}
