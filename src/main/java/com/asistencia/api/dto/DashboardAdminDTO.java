package com.asistencia.api.dto;

import java.util.List;

// Todo lo que muestra el dashboard de Administrador/Supervisor en una sola respuesta JSON
public record DashboardAdminDTO(
        long totalEmpleados,
        long presentes,
        long tardanzas,
        long faltas,
        List<AsistenciaDTO> asistenciaHoy,
        List<PermisoDTO> permisosPendientes
) {
}
