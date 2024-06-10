package com.gestion.notasExamen.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudenCsvRepresentation {

  @CsvBindByName(column = "name")
  private String name;

  @CsvBindByName(column = "lastName")
  private String lastName;

  @CsvBindByName(column = "dni")
  private String dni;

  @CsvBindByName(column = "email")
  private String email;

  @CsvBindByName(column = "userName")
  private String userName;

  @CsvBindByName(column = "password")
  private String password;

  @CsvBindByName(column = "role")
  private Role role;
}
