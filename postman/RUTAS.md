# Rutas para Postman

Todas las rutas ya estan cargadas en la coleccion.

## Login

`POST http://localhost:8130/api/auth/login`

```json
{
  "username": "admin",
  "password": "admin123"
}
```

## Hoteles

`GET http://localhost:8130/api/hoteles`

`GET http://localhost:8130/api/hoteles/HOT001`

## Categorias

`GET http://localhost:8130/api/categorias`

`GET http://localhost:8130/api/categorias/CAT001`

## Habitaciones

`GET http://localhost:8130/api/habitaciones`

`POST http://localhost:8130/api/habitaciones`

```json
{
  "codigoHabitacion": "HAB999",
  "codigoHotel": "HOT001",
  "nroHabitacion": "202",
  "codigoCategoria": "CAT001",
  "capacidadMaxima": 2,
  "estado": "A"
}
```

`GET http://localhost:8130/api/habitaciones/HAB999`

`PUT http://localhost:8130/api/habitaciones/HAB999`

```json
{
  "codigoHotel": "HOT001",
  "nroHabitacion": "203",
  "codigoCategoria": "CAT002",
  "capacidadMaxima": 3,
  "estado": "A"
}
```

`PUT http://localhost:8130/api/habitaciones/HAB999/desactivar`

`PUT http://localhost:8130/api/habitaciones/HAB999/activar`

`DELETE http://localhost:8130/api/habitaciones/HAB999`

## Seguridad

`GET http://localhost:8130/api/auth/seguridad/roles/ROLE_ADMIN/permisos`

`POST http://localhost:8130/api/auth/seguridad/roles`

`POST http://localhost:8130/api/auth/seguridad/permisos`

`POST http://localhost:8130/api/auth/seguridad/usuarios/asignar-rol`

`POST http://localhost:8130/api/auth/seguridad/roles/asignar-permiso`

`POST http://localhost:8130/api/auth/seguridad/permisos/default`
