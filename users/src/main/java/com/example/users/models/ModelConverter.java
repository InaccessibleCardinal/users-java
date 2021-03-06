package com.example.users.models;

public interface ModelConverter<Q, M, S> {
    M requestToModel(Q request);
    S modelToResponse(M model);
}
