package com.gestion.notasExamen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="dni")
    private String dni;

}
