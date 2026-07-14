package com.asistencia.api.repository;

import com.asistencia.api.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    // Conteo de asistencias de una fecha con un estado (PRESENTE / TARDANZA / FALTA)
    long countByFechaAndEstado(LocalDate fecha, String estado);

    // Lista de asistencias de una fecha (para la tabla del dashboard admin)
    List<Asistencia> findByFecha(LocalDate fecha);

    // Asistencias de un empleado, mas recientes primero (dashboard del empleado)
    List<Asistencia> findByUsuario_IdUsuarioOrderByFechaDesc(Integer idUsuario);
}
