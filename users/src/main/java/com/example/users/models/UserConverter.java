package com.example.users.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import security.PasswordManager;

import java.text.SimpleDateFormat;

@Component
public class UserConverter implements ModelConverter<UserRequest, UserModel, User> {

    @Autowired
    PasswordManager passwordManager;

    @Override
    public UserModel requestToModel(UserRequest request) {
        UserModel model = new UserModel();
        model.setFirstName(request.getFirstName());
        model.setLastName(request.getLastName());
        model.setEmail(request.getEmail());
        model.setUsername(request.getUsername());
        model.setPassword(
                passwordManager.hashPassword(request.getPassword())
        );
        return model;
    }

    @Override
    public User modelToResponse(UserModel model) {
        User response = new User();
        response.setId(model.getId());
        response.setFirstName(model.getFirstName());
        response.setLastName(model.getLastName());
        response.setEmail(model.getEmail());
        response.setUsername(model.getUsername());
        response.setPassword(model.getPassword());
        response.setAddDate(new SimpleDateFormat("MMM d, yyyy").format(model.getAddTs()));
        return response;
    }
}
