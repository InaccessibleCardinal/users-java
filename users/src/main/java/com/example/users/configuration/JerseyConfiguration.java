package com.example.users.configuration;

import com.example.users.controllers.LoginController;
import com.example.users.controllers.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {

        register(UserController.class);
        register(LoginController.class);
    }
}
