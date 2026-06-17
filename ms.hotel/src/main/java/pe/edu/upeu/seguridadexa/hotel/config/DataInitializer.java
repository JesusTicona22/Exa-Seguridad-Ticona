package pe.edu.upeu.seguridadexa.hotel.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.edu.upeu.seguridadexa.hotel.entity.Hotel;
import pe.edu.upeu.seguridadexa.hotel.repository.HotelRepository;

@ApplicationScoped
public class DataInitializer {

    @Inject
    HotelRepository repository;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        crearSiNoExiste("HOT001", "Hotel Central", "LIM");
        crearSiNoExiste("HOT002", "Hotel Plaza", "CUS");
        crearSiNoExiste("HOT003", "Hotel Paraiso", "AQP");
    }

    private void crearSiNoExiste(String codigoHotel, String descripcion, String codCiudad) {
        if (repository.findById(codigoHotel) != null) {
            return;
        }

        Hotel hotel = new Hotel();
        hotel.setCodigoHotel(codigoHotel);
        hotel.setDescripcion(descripcion);
        hotel.setCodCiudad(codCiudad);
        repository.persist(hotel);
    }
}
