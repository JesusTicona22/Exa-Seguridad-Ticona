# SEGURIDAD-EXA

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
