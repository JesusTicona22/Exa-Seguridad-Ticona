package pe.edu.upeu.seguridadexa.auth.services;

import pe.edu.upeu.seguridadexa.auth.dto.AsignarPermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.AsignarRolRequest;
import pe.edu.upeu.seguridadexa.auth.dto.PermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.RolRequest;
import pe.edu.upeu.seguridadexa.auth.entity.Permiso;
import pe.edu.upeu.seguridadexa.auth.entity.Rol;
import java.util.List;
import java.util.stream.Collectors;

public interface SeguridadService {

    Rol crearRol(RolRequest request);

    Permiso crearPermiso(PermisoRequest request);

    String asignarRolAUsuario(AsignarRolRequest request);

    String asignarPermisoARol(AsignarPermisoRequest request);

    String crearPermisosDefault();

    List<String> listarPermisosPorRol(String nombreRol);
}