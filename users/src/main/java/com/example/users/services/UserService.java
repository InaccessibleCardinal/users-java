package com.example.users.services;

import com.example.users.dao.UserRepository;
import com.example.users.models.User;
import com.example.users.models.UserConverter;
import com.example.users.models.UserModel;
import com.example.users.models.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserConverter userConverter;
    @Autowired
    UserRepository userRepository;

    public User save(final UserRequest userRequest) {
        UserModel userModel = userConverter.requestToModel(userRequest);
        userModel.setAddTs(new Date());
        User userWithUsername = this.findByUsername(userModel.getUsername());
        if (null == userWithUsername) {
            return userConverter.modelToResponse(userRepository.save(userModel));
        }
        return null;
    }

    public List<User> findAll() {
        final List<UserModel> allUsers = userRepository.findAll();
        List<User> usersResponse = new ArrayList<>();
        for (UserModel u : allUsers) {
            usersResponse.add(userConverter.modelToResponse(u));
        }
        return usersResponse;
    }
    public User findByUsername(String username) {
        try {
            List<UserModel> userList = userRepository.findByUsername(username);
            if (userList.isEmpty()) {
                return null;
            }
            return userConverter.modelToResponse(userList.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
