package pe.edu.upeu.seguridadexa.categoria.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.edu.upeu.seguridadexa.categoria.entity.Categoria;
import pe.edu.upeu.seguridadexa.categoria.repository.CategoriaRepository;

import java.util.List;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaController {

    @Inject
    CategoriaRepository repository;

    @GET
    public List<Categoria> list() {
        return repository.listAll();
    }

    @GET
    @Path("/{codigoCategoria}")
    public Categoria get(@PathParam("codigoCategoria") String codigoCategoria) {
        return repository.findById(codigoCategoria);
    }
}
