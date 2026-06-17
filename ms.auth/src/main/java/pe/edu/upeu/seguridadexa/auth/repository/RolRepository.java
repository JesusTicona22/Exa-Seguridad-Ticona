package pe.edu.upeu.seguridadexa.auth.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.auth.entity.Rol;

@ApplicationScoped
public class RolRepository implements PanacheRepository<Rol> {

    public Rol findByNombre(String nombre) {
        return find("nombre", nombre).firstResult();
    }
}