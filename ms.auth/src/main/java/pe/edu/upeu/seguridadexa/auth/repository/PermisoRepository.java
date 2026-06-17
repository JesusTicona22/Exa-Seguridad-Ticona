package pe.edu.upeu.seguridadexa.auth.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.auth.entity.Permiso;

@ApplicationScoped
public class PermisoRepository implements PanacheRepository<Permiso> {
}