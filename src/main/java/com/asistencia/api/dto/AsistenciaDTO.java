package com.asistencia.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Fila de asistencia lista para mostrar (con el nombre del empleado ya resuelto)
public record AsistenciaDTO(String nombreEmpleado, LocalDate fecha, String estado, LocalDateTime horaEntrada) {
}
