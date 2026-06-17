package pe.edu.upeu.seguridadexa.auth.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pe.edu.upeu.seguridadexa.auth.dto.AsignarPermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.AsignarRolRequest;
import pe.edu.upeu.seguridadexa.auth.dto.PermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.RolRequest;
import pe.edu.upeu.seguridadexa.auth.entity.Permiso;
import pe.edu.upeu.seguridadexa.auth.entity.Rol;
import pe.edu.upeu.seguridadexa.auth.services.SeguridadService;

@Path("/auth/seguridad")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SeguridadController {

    @Inject
    SeguridadService seguridadService;

    @POST
    @Path("/roles")
    public Rol crearRol(RolRequest request) {
        return seguridadService.crearRol(request);
    }

    @POST
    @Path("/permisos")
    public Permiso crearPermiso(PermisoRequest request) {
        return seguridadService.crearPermiso(request);
    }

    @POST
    @Path("/permisos/default")
    public String crearPermisosDefault() {
        return seguridadService.crearPermisosDefault();
    }

    @GET
    @Path("/roles/{nombreRol}/permisos")
    public java.util.List<String> listarPermisosPorRol(@PathParam("nombreRol") String nombreRol) {
        return seguridadService.listarPermisosPorRol(nombreRol);
    }

    @POST
    @Path("/usuarios/asignar-rol")
    public String asignarRolAUsuario(AsignarRolRequest request) {
        return seguridadService.asignarRolAUsuario(request);
    }

    @POST
    @Path("/roles/asignar-permiso")
    public String asignarPermisoARol(AsignarPermisoRequest request) {
        return seguridadService.asignarPermisoARol(request);
    }
}