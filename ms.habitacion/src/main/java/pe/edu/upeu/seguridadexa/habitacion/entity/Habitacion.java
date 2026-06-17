package pe.edu.upeu.seguridadexa.habitacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @Column(length = 10)
    private String codigoHabitacion;

    @Column(nullable = false, length = 10)
    private String codigoHotel;

    @Column(nullable = false, length = 10)
    private String nroHabitacion;

    @Column(nullable = false, length = 10)
    private String codigoCategoria;

    @Column(nullable = false)
    private Integer capacidadMaxima;

    @Column(nullable = false, length = 1)
    private String estado;

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(String codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    public String getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(String nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
