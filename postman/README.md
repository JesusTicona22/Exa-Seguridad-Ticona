# Postman - SEGURIDAD-EXA Hotel

Importa estos dos archivos en Postman:

1. `SEGURIDAD-EXA.postman_collection.json`
2. `SEGURIDAD-EXA.postman_environment.json`

Selecciona el environment `SEGURIDAD-EXA Local`.

## Orden recomendado

1. Ejecuta `00 Health / Gateway Health`.
2. Ejecuta `01 Auth / Login Admin`.
3. Ejecuta `02 Hotel / Listar Hoteles`.
4. Ejecuta `03 Categoria / Listar Categorias`.
5. Ejecuta las peticiones de `04 Habitacion`.

El login guarda automaticamente el JWT en la variable `token`.

## Rutas listas

- `POST http://localhost:8130/api/auth/login`
- `GET http://localhost:8130/api/hoteles`
- `GET http://localhost:8130/api/categorias`
- `GET http://localhost:8130/api/habitaciones`
- `POST http://localhost:8130/api/habitaciones`
- `GET http://localhost:8130/api/habitaciones/HAB999`
- `PUT http://localhost:8130/api/habitaciones/HAB999`
- `PUT http://localhost:8130/api/habitaciones/HAB999/desactivar`
- `PUT http://localhost:8130/api/habitaciones/HAB999/activar`
- `DELETE http://localhost:8130/api/habitaciones/HAB999`
