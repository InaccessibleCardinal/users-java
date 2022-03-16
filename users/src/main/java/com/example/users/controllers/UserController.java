package com.example.users.controllers;

import com.example.users.models.ApiResponse;
import com.example.users.models.UserLoginRequest;
import com.example.users.models.UserRequest;
import com.example.users.models.User;
import com.example.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Component
public class UserController {
    @Autowired
    UserService userService;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(final UserRequest userRequest) {
        try {
            User user = userService.save(userRequest);
            if (null == user) {
                return Response
                        .status(400)
                        .entity(new ApiResponse(400, "username unavailable", null))
                        .build();
            }
            return Response
                    .ok(new ApiResponse(201, "created", user.getId()))
                    .build();
        } catch (Exception ex) {
            return Response.status(500).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<User> users = userService.findAll();
        return Response
                .ok(new ApiResponse(200, "ok", users))
                .build();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUsername(@PathParam("username") String username) {
        User user = userService.findByUsername(username);
        return Response
                .ok(new ApiResponse(200, "ok", user))
                .build();
    }
}
