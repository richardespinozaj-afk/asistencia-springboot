package com.asistencia.api.repository;

import com.asistencia.api.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    // Permisos por estado (ej. los PENDIENTE para el dashboard admin)
    List<Permiso> findByEstado(String estado);

    // Permisos de un empleado, mas recientes primero (dashboard del empleado)
    List<Permiso> findByUsuario_IdUsuarioOrderByFechaSolicitudDesc(Integer idUsuario);
}
