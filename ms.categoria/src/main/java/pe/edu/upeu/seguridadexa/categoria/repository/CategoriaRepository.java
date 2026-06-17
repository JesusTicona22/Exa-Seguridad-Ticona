package pe.edu.upeu.seguridadexa.categoria.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.categoria.entity.Categoria;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, String> {
}
