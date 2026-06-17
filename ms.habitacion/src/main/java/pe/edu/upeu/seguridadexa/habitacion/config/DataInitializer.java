package pe.edu.upeu.seguridadexa.habitacion.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.edu.upeu.seguridadexa.habitacion.entity.Habitacion;
import pe.edu.upeu.seguridadexa.habitacion.repository.HabitacionRepository;

@ApplicationScoped
public class DataInitializer {

    @Inject
    HabitacionRepository repository;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        if (repository.findById("HAB001") != null) {
            return;
        }

        Habitacion habitacion = new Habitacion();
        habitacion.setCodigoHabitacion("HAB001");
        habitacion.setCodigoHotel("HOT001");
        habitacion.setNroHabitacion("101");
        habitacion.setCodigoCategoria("CAT001");
        habitacion.setCapacidadMaxima(2);
        habitacion.setEstado("A");
        repository.persist(habitacion);
    }
}
