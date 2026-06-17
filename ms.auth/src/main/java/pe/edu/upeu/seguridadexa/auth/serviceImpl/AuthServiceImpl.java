package pe.edu.upeu.seguridadexa.auth.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import pe.edu.upeu.seguridadexa.auth.dto.LoginRequest;
import pe.edu.upeu.seguridadexa.auth.dto.LoginResponse;
import pe.edu.upeu.seguridadexa.auth.entity.Usuario;
import pe.edu.upeu.seguridadexa.auth.entity.UsuarioRol;
import pe.edu.upeu.seguridadexa.auth.repository.UsuarioRepository;
import pe.edu.upeu.seguridadexa.auth.repository.UsuarioRolRepository;
import pe.edu.upeu.seguridadexa.auth.security.JwtService;
import pe.edu.upeu.seguridadexa.auth.services.AuthService;

import java.util.List;

@ApplicationScoped
public class AuthServiceImpl implements AuthService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioRolRepository usuarioRolRepository;

    @Inject
    JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository.findByUsername(request.username);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        if (!usuario.password.equals(request.password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        if (!usuario.estado) {
            throw new RuntimeException("Usuario inactivo");
        }

        List<UsuarioRol> rolesUsuario = usuarioRolRepository.findByUsuarioId(usuario.id);

        if (rolesUsuario == null || rolesUsuario.isEmpty()) {
            throw new RuntimeException("El usuario no tiene roles asignados");
        }

        String rolPrincipal = rolesUsuario.get(0).rol.nombre;

        String token = jwtService.generarToken(usuario.username, rolPrincipal);

        return new LoginResponse(token, rolPrincipal);
    }
}