package pe.edu.upeu.seguridadexa.auth.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.auth.entity.UsuarioRol;

import java.util.List;

@ApplicationScoped
public class UsuarioRolRepository implements PanacheRepository<UsuarioRol> {

    public List<UsuarioRol> findByUsuarioId(Long usuarioId) {
        return list("usuario.id", usuarioId);
    }
}