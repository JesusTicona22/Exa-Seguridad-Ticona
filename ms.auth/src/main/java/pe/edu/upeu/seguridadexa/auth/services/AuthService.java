package pe.edu.upeu.seguridadexa.auth.services;

import pe.edu.upeu.seguridadexa.auth.dto.LoginRequest;
import pe.edu.upeu.seguridadexa.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}