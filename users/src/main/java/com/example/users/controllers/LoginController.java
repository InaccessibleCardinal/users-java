package com.example.users.controllers;

import com.example.users.models.ApiResponse;
import com.example.users.models.UserLoginRequest;
import com.example.users.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
@Component
public class LoginController {

    @Autowired
    LoginService loginService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(final UserLoginRequest loginRequest) {
        if (loginService.login(loginRequest)) {
            return Response
                    .ok(new ApiResponse(200, "success", "loggedIn"))
                    .build();
        }
        return Response.status(400).build();
    }
}
