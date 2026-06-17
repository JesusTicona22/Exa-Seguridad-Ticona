package pe.edu.upeu.seguridadexa.auth.serviceImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pe.edu.upeu.seguridadexa.auth.dto.AsignarPermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.AsignarRolRequest;
import pe.edu.upeu.seguridadexa.auth.dto.PermisoRequest;
import pe.edu.upeu.seguridadexa.auth.dto.RolRequest;
import pe.edu.upeu.seguridadexa.auth.entity.*;
import pe.edu.upeu.seguridadexa.auth.repository.*;
import pe.edu.upeu.seguridadexa.auth.services.SeguridadService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SeguridadServiceImpl implements SeguridadService {

    @Inject
    RolRepository rolRepository;

    @Inject
    PermisoRepository permisoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioRolRepository usuarioRolRepository;

    @Inject
    RolPermisoRepository rolPermisoRepository;

    @Override
    @Transactional
    public Rol crearRol(RolRequest request) {
        Rol rol = new Rol();
        rol.nombre = request.nombre;
        rol.descripcion = request.descripcion;
        rol.estado = true;

        rolRepository.persist(rol);
        return rol;
    }

    @Override
    @Transactional
    public Permiso crearPermiso(PermisoRequest request) {
        Permiso permiso = new Permiso();
        permiso.nombre = request.nombre;
        permiso.metodo = request.metodo;
        permiso.endpoint = request.endpoint;
        permiso.estado = true;

        permisoRepository.persist(permiso);
        return permiso;
    }

    @Override
    @Transactional
    public String asignarRolAUsuario(AsignarRolRequest request) {
        Usuario usuario = usuarioRepository.findById(request.usuarioId);
        Rol rol = rolRepository.findById(request.rolId);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        if (rol == null) {
            throw new RuntimeException("Rol no encontrado");
        }

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.usuario = usuario;
        usuarioRol.rol = rol;

        usuarioRolRepository.persist(usuarioRol);

        return "Rol asignado correctamente al usuario";
    }

    @Override
    @Transactional
    public String asignarPermisoARol(AsignarPermisoRequest request) {
        Rol rol = rolRepository.findById(request.rolId);
        Permiso permiso = permisoRepository.findById(request.permisoId);

        if (rol == null) {
            throw new RuntimeException("Rol no encontrado");
        }

        if (permiso == null) {
            throw new RuntimeException("Permiso no encontrado");
        }

        RolPermiso rolPermiso = new RolPermiso();
        rolPermiso.rol = rol;
        rolPermiso.permiso = permiso;

        rolPermisoRepository.persist(rolPermiso);

        return "Permiso asignado correctamente al rol";
    }

    @Override
    @Transactional
    public String crearPermisosDefault() {

        crearPermisoSiNoExiste("LISTAR_HABITACIONES", "GET", "/habitaciones/**");
        crearPermisoSiNoExiste("CREAR_HABITACIONES", "POST", "/habitaciones/**");
        crearPermisoSiNoExiste("EDITAR_HABITACIONES", "PUT", "/habitaciones/**");
        crearPermisoSiNoExiste("ELIMINAR_HABITACIONES", "DELETE", "/habitaciones/**");

        crearPermisoSiNoExiste("LISTAR_HOTELES", "GET", "/hoteles/**");
        crearPermisoSiNoExiste("LISTAR_CATEGORIAS", "GET", "/categorias/**");

        crearPermisoSiNoExiste("CREAR_ROLES", "POST", "/auth/seguridad/roles");
        crearPermisoSiNoExiste("CREAR_PERMISOS", "POST", "/auth/seguridad/permisos");
        crearPermisoSiNoExiste("CREAR_PERMISOS_DEFAULT", "POST", "/auth/seguridad/permisos/default");
        crearPermisoSiNoExiste("ASIGNAR_ROL_USUARIO", "POST", "/auth/seguridad/usuarios/asignar-rol");
        crearPermisoSiNoExiste("ASIGNAR_PERMISO_ROL", "POST", "/auth/seguridad/roles/asignar-permiso");
        crearPermisoSiNoExiste("VER_PERMISOS_ROL", "GET", "/auth/seguridad/roles/**/permisos");

        return "Permisos default creados correctamente";
    }

    @Override
    public List<String> listarPermisosPorRol(String nombreRol) {
        return rolPermisoRepository.findByRolNombre(nombreRol)
                .stream()
                .map(rp -> rp.permiso.metodo + " " + rp.permiso.endpoint)
                .collect(Collectors.toList());
    }

    private void crearPermisoSiNoExiste(String nombre, String metodo, String endpoint) {
        Permiso existe = permisoRepository.find("nombre", nombre).firstResult();

        if (existe == null) {
            existe = new Permiso();
            existe.nombre = nombre;
        }

        existe.metodo = metodo;
        existe.endpoint = endpoint;
        existe.estado = true;
        permisoRepository.persist(existe);
    }
}
