package com.example.users.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ApiResponse {
    @Getter
    @Setter
    int status;
    @Getter
    @Setter
    String message;
    @Getter
    @Setter
    Object result;
}
