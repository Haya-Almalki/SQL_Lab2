package com.example.sql_exercise_day2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponse {
    private String message;
    private Integer status;
}
