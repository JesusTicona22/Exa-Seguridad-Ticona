package pe.edu.upeu.seguridadexa.habitacion.services;

import pe.edu.upeu.seguridadexa.habitacion.entity.Habitacion;

import java.util.List;

public interface HabitacionService {

    Habitacion create(Habitacion habitacion);

    List<Habitacion> findAll();

    Habitacion findById(String codigoHabitacion);

    Habitacion update(String codigoHabitacion, Habitacion habitacion);

    void delete(String codigoHabitacion);

    Habitacion desactivar(String codigoHabitacion);

    Habitacion activar(String codigoHabitacion);
}
