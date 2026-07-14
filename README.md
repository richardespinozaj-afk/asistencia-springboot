# Asistencia API (Spring Boot)

Backend REST del Sistema de Control de Asistencia — módulo **Dashboard**.
Se conecta a la misma base de datos MySQL (`sistema_asistencia`) que el sistema en Servlets/JSP.

## Requisitos
- JDK 17
- MySQL con la base `sistema_asistencia`
- Maven (incluido en NetBeans)

## Configuración
Editar `src/main/resources/application.properties` si tu MySQL usa otro usuario/clave.
Por defecto: `localhost:3306`, usuario `root`, clave `root`. Corre en el puerto **8081**.

## Ejecutar
Abrir el proyecto en NetBeans/VS Code y ejecutar la clase `AsistenciaApiApplication`.
Probar: http://localhost:8081/api/dashboard/admin

## Endpoints
- `POST /api/auth/login`
- `GET  /api/dashboard/admin`
- `GET  /api/dashboard/empleado/{id}`
