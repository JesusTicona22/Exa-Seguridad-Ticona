package pe.edu.upeu.seguridadexa.categoria.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.edu.upeu.seguridadexa.categoria.entity.Categoria;
import pe.edu.upeu.seguridadexa.categoria.repository.CategoriaRepository;

@ApplicationScoped
public class DataInitializer {

    @Inject
    CategoriaRepository repository;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        crearSiNoExiste("CAT001", "Simple");
        crearSiNoExiste("CAT002", "Doble");
        crearSiNoExiste("CAT003", "Suite");
    }

    private void crearSiNoExiste(String codigoCategoria, String descripcion) {
        if (repository.findById(codigoCategoria) != null) {
            return;
        }

        Categoria categoria = new Categoria();
        categoria.setCodigoCategoria(codigoCategoria);
        categoria.setDescripcion(descripcion);
        repository.persist(categoria);
    }
}
