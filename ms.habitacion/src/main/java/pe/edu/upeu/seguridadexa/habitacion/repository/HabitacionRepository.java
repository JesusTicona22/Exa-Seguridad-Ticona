package pe.edu.upeu.seguridadexa.habitacion.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import pe.edu.upeu.seguridadexa.habitacion.entity.Habitacion;

@ApplicationScoped
public class HabitacionRepository implements PanacheRepositoryBase<Habitacion, String> {
}
