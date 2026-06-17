package pe.edu.upeu.seguridadexa.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hotel {

    @Id
    @Column(length = 10)
    private String codigoHotel;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, length = 10)
    private String codCiudad;

    public String getCodigoHotel() {
        return codigoHotel;
    }

    public void setCodigoHotel(String codigoHotel) {
        this.codigoHotel = codigoHotel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }
}
