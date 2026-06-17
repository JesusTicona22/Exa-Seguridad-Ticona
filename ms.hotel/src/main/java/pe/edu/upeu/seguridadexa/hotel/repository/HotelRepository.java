package pe.edu.upeu.seguridadexa.hotel.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.hotel.entity.Hotel;

@ApplicationScoped
public class HotelRepository implements PanacheRepositoryBase<Hotel, String> {
}
