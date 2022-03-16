package com.example.users.services;

import com.example.users.dao.UserRepository;

import com.example.users.models.User;
import com.example.users.models.UserLoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import security.PasswordManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class LoginServiceTest {

    @InjectMocks
    LoginService loginService;
    @Mock
    UserRepository userRepository;
    @Mock
    UserService userService;
    @Mock
    PasswordManager passwordManager;
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setPassword("password");
        userLoginRequest.setUsername("username");
        User mockUser = new User();
        mockUser.setUsername("username");
        mockUser.setPassword("encodedPassword");
        when(userService.findByUsername("username")).thenReturn(mockUser);
        when(
                passwordManager.isPasswordValid("password", "encodedPassword")
        ).thenReturn(true);
        Boolean result = loginService.login(userLoginRequest);
        assertTrue(result);

    }
}