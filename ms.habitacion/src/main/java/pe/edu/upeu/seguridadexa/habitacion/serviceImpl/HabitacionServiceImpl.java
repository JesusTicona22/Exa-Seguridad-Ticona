package pe.edu.upeu.seguridadexa.habitacion.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.edu.upeu.seguridadexa.habitacion.entity.Habitacion;
import pe.edu.upeu.seguridadexa.habitacion.errors.ConflictException;
import pe.edu.upeu.seguridadexa.habitacion.errors.NotFoundException;
import pe.edu.upeu.seguridadexa.habitacion.repository.HabitacionRepository;
import pe.edu.upeu.seguridadexa.habitacion.services.HabitacionService;

import java.util.List;

@ApplicationScoped
public class HabitacionServiceImpl implements HabitacionService {

    @Inject
    HabitacionRepository repository;

    @Override
    @Transactional
    public Habitacion create(Habitacion habitacion) {
        if (repository.findById(habitacion.getCodigoHabitacion()) != null) {
            throw new ConflictException("La habitacion ya existe: " + habitacion.getCodigoHabitacion());
        }

        if (habitacion.getEstado() == null || habitacion.getEstado().isBlank()) {
            habitacion.setEstado("A");
        }

        repository.persist(habitacion);
        return habitacion;
    }

    @Override
    public List<Habitacion> findAll() {
        return repository.listAll();
    }

    @Override
    public Habitacion findById(String codigoHabitacion) {
        Habitacion habitacion = repository.findById(codigoHabitacion);

        if (habitacion == null) {
            throw new NotFoundException("Habitacion no encontrada: " + codigoHabitacion);
        }

        return habitacion;
    }

    @Override
    @Transactional
    public Habitacion update(String codigoHabitacion, Habitacion habitacion) {
        Habitacion entity = findById(codigoHabitacion);

        entity.setCodigoHotel(habitacion.getCodigoHotel());
        entity.setNroHabitacion(habitacion.getNroHabitacion());
        entity.setCodigoCategoria(habitacion.getCodigoCategoria());
        entity.setCapacidadMaxima(habitacion.getCapacidadMaxima());
        entity.setEstado(habitacion.getEstado());

        return entity;
    }

    @Override
    @Transactional
    public void delete(String codigoHabitacion) {
        if (!repository.deleteById(codigoHabitacion)) {
            throw new NotFoundException("Habitacion no encontrada: " + codigoHabitacion);
        }
    }

    @Override
    @Transactional
    public Habitacion desactivar(String codigoHabitacion) {
        Habitacion habitacion = findById(codigoHabitacion);
        habitacion.setEstado("I");
        return habitacion;
    }

    @Override
    @Transactional
    public Habitacion activar(String codigoHabitacion) {
        Habitacion habitacion = findById(codigoHabitacion);
        habitacion.setEstado("A");
        return habitacion;
    }
}
