# SEGURIDAD-EXA

Plantilla dockerizada para examen con:

- API Gateway
- Consul
- Config central
- Seguridad/JWT
- Microservicio principal completo: `ms.habitacion`
- Microservicios de apoyo: `ms.hotel` y `ms.categoria`
- MySQL como base de datos unica y ligera (`seguridad_exa`)

## Puertos

- API Gateway: `http://localhost:8130`
- Consul UI: `http://localhost:8510`
- MySQL: `localhost:3317`
- ms.habitacion directo: `http://localhost:8182`
- ms.hotel directo: `http://localhost:8185`
- ms.categoria directo: `http://localhost:8186`
- ms.auth directo: `http://localhost:8184`

## Comandos

Construir y levantar todo:

```bash
docker compose up --build
```

Levantar en segundo plano:

```bash
docker compose up --build -d
```

Apagar:

```bash
docker compose down
```

Recrear tambien la base de datos:

```bash
docker compose down -v
docker compose up --build
```

## Rutas por gateway

- Login: `POST http://localhost:8130/api/auth/login`
- Habitaciones: `http://localhost:8130/api/habitaciones`
- Hoteles: `http://localhost:8130/api/hoteles`
- Categorias: `http://localhost:8130/api/categorias`

Las rutas protegidas pasan por el filtro JWT del gateway.

Usuario inicial:

- Usuario: `admin`
- Password: `admin123`
- Rol: `ROLE_ADMIN`
