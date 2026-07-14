package com.asistencia.api.service;

import com.asistencia.api.dto.*;
import com.asistencia.api.model.Asistencia;
import com.asistencia.api.model.Permiso;
import com.asistencia.api.repository.AsistenciaRepository;
import com.asistencia.api.repository.PermisoRepository;
import com.asistencia.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Aqui va la logica del dashboard: arma los DTOs a partir de lo que devuelven los repositorios.
@Service
public class DashboardService {

    private final UsuarioRepository usuarioRepo;
    private final AsistenciaRepository asistenciaRepo;
    private final PermisoRepository permisoRepo;

    // Spring inyecta automaticamente los repositorios (inyeccion por constructor)
    public DashboardService(UsuarioRepository usuarioRepo,
                            AsistenciaRepository asistenciaRepo,
                            PermisoRepository permisoRepo) {
        this.usuarioRepo = usuarioRepo;
        this.asistenciaRepo = asistenciaRepo;
        this.permisoRepo = permisoRepo;
    }

    // ── Dashboard para Administrador / Supervisor ──
    public DashboardAdminDTO obtenerDashboardAdmin() {
        LocalDate hoy = LocalDate.now();

        long totalEmpleados = usuarioRepo.count();
        long presentes = asistenciaRepo.countByFechaAndEstado(hoy, "PRESENTE");
        long tardanzas = asistenciaRepo.countByFechaAndEstado(hoy, "TARDANZA");
        long faltas    = asistenciaRepo.countByFechaAndEstado(hoy, "FALTA");

        List<AsistenciaDTO> asistenciaHoy = asistenciaRepo.findByFecha(hoy)
                .stream().map(this::aAsistenciaDTO).toList();

        List<PermisoDTO> permisosPendientes = permisoRepo.findByEstado("PENDIENTE")
                .stream().map(this::aPermisoDTO).toList();

        return new DashboardAdminDTO(totalEmpleados, presentes, tardanzas, faltas,
                asistenciaHoy, permisosPendientes);
    }

    // ── Dashboard para un Empleado (solo sus datos) ──
    public DashboardEmpleadoDTO obtenerDashboardEmpleado(Integer idUsuario) {
        List<Asistencia> misAsistencias = asistenciaRepo.findByUsuario_IdUsuarioOrderByFechaDesc(idUsuario);

        long presentes = misAsistencias.stream().filter(a -> "PRESENTE".equals(a.getEstado())).count();
        long tardanzas = misAsistencias.stream().filter(a -> "TARDANZA".equals(a.getEstado())).count();
        long faltas    = misAsistencias.stream().filter(a -> "FALTA".equals(a.getEstado())).count();

        List<AsistenciaDTO> asistenciasDTO = misAsistencias.stream().map(this::aAsistenciaDTO).toList();
        List<PermisoDTO> permisosDTO = permisoRepo
                .findByUsuario_IdUsuarioOrderByFechaSolicitudDesc(idUsuario)
                .stream().map(this::aPermisoDTO).toList();

        return new DashboardEmpleadoDTO(presentes, tardanzas, faltas, asistenciasDTO, permisosDTO);
    }

    // ── Conversores de entidad a DTO ──
    private AsistenciaDTO aAsistenciaDTO(Asistencia a) {
        String nombre = a.getUsuario() != null ? a.getUsuario().getNombreCompleto() : "";
        return new AsistenciaDTO(nombre, a.getFecha(), a.getEstado(), a.getHoraEntrada());
    }

    private PermisoDTO aPermisoDTO(Permiso p) {
        String nombre = p.getUsuario() != null ? p.getUsuario().getNombreCompleto() : "";
        return new PermisoDTO(nombre, p.getTipoPermiso(), p.getFechaInicio(), p.getFechaFin(), p.getEstado());
    }
}
