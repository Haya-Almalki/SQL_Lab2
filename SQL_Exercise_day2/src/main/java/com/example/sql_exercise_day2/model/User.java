package com.example.sql_exercise_day2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data @NoArgsConstructor
@Entity
public class User {

    @NotNull(message="id must be not null")
    @Id
    private Integer id;
    @NotEmpty(message = "username must be not empty")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String username;
    @NotEmpty(message ="password must be not empty")
    private String password;
    @NotEmpty(message ="role must be not empty")
    @Column(columnDefinition = "varchar(10) check (role='ADMIN' or role='USER')")
    private String role;

}
