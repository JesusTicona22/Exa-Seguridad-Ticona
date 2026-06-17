package pe.edu.upeu.seguridadexa.auth.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pe.edu.upeu.seguridadexa.auth.dto.LoginRequest;
import pe.edu.upeu.seguridadexa.auth.dto.LoginResponse;
import pe.edu.upeu.seguridadexa.auth.services.AuthService;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    public LoginResponse login(LoginRequest request) {
        return authService.login(request);
    }
}