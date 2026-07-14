package com.asistencia.api.dto;

import java.util.List;

// Todo lo que muestra el dashboard del Empleado (solo sus propios datos)
public record DashboardEmpleadoDTO(
        long misPresentes,
        long misTardanzas,
        long misFaltas,
        List<AsistenciaDTO> misAsistencias,
        List<PermisoDTO> misPermisos
) {
}
