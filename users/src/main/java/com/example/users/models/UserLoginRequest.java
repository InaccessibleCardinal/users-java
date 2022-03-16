package com.example.users.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class UserLoginRequest {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}
