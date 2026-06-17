package pe.edu.upeu.seguridadexa.habitacion.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.edu.upeu.seguridadexa.habitacion.entity.Habitacion;
import pe.edu.upeu.seguridadexa.habitacion.services.HabitacionService;

import java.util.List;

@Path("/habitaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitacionController {

    @Inject
    HabitacionService service;

    @GET
    public List<Habitacion> list() {
        return service.findAll();
    }

    @GET
    @Path("/{codigoHabitacion}")
    public Habitacion get(@PathParam("codigoHabitacion") String codigoHabitacion) {
        return service.findById(codigoHabitacion);
    }

    @POST
    public Habitacion create(Habitacion habitacion) {
        return service.create(habitacion);
    }

    @PUT
    @Path("/{codigoHabitacion}")
    public Habitacion update(@PathParam("codigoHabitacion") String codigoHabitacion, Habitacion habitacion) {
        return service.update(codigoHabitacion, habitacion);
    }

    @DELETE
    @Path("/{codigoHabitacion}")
    public void delete(@PathParam("codigoHabitacion") String codigoHabitacion) {
        service.delete(codigoHabitacion);
    }

    @PUT
    @Path("/{codigoHabitacion}/desactivar")
    public Habitacion desactivar(@PathParam("codigoHabitacion") String codigoHabitacion) {
        return service.desactivar(codigoHabitacion);
    }

    @PUT
    @Path("/{codigoHabitacion}/activar")
    public Habitacion activar(@PathParam("codigoHabitacion") String codigoHabitacion) {
        return service.activar(codigoHabitacion);
    }
}
