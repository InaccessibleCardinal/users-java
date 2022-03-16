package com.example.users.services;

import com.example.users.models.User;
import com.example.users.models.UserLoginRequest;
import com.example.users.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.PasswordManager;

import javax.transaction.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    PasswordManager passwordManager;

    public Boolean login(final UserLoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        User user = userService.findByUsername(username);
        if (null == user) {
            // TODO bad username
            return false;
        }
        if (passwordManager.isPasswordValid(password, user.getPassword())) {
            // TODO something with login
            return true;
        }
        // TODO bad password
        return false;
    }
}
