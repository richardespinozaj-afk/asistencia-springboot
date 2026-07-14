package com.asistencia.api.dto;

import java.time.LocalDate;

// Fila de permiso lista para mostrar
public record PermisoDTO(String nombreEmpleado, String tipoPermiso, LocalDate fechaInicio,
                         LocalDate fechaFin, String estado) {
}
