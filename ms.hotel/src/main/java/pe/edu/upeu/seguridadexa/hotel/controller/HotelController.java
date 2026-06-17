package pe.edu.upeu.seguridadexa.hotel.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.edu.upeu.seguridadexa.hotel.entity.Hotel;
import pe.edu.upeu.seguridadexa.hotel.repository.HotelRepository;

import java.util.List;

@Path("/hoteles")
@Produces(MediaType.APPLICATION_JSON)
public class HotelController {

    @Inject
    HotelRepository repository;

    @GET
    public List<Hotel> list() {
        return repository.listAll();
    }

    @GET
    @Path("/{codigoHotel}")
    public Hotel get(@PathParam("codigoHotel") String codigoHotel) {
        return repository.findById(codigoHotel);
    }
}
