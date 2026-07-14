package com.asistencia.api.controller;

import com.asistencia.api.dto.DashboardAdminDTO;
import com.asistencia.api.dto.DashboardEmpleadoDTO;
import com.asistencia.api.service.DashboardService;
import org.springframework.web.bind.annotation.*;

// Expone los datos del dashboard como JSON.
// Rutas: GET /api/dashboard/admin   y   GET /api/dashboard/empleado/{idUsuario}
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/admin")
    public DashboardAdminDTO dashboardAdmin() {
        return service.obtenerDashboardAdmin();
    }

    @GetMapping("/empleado/{idUsuario}")
    public DashboardEmpleadoDTO dashboardEmpleado(@PathVariable Integer idUsuario) {
        return service.obtenerDashboardEmpleado(idUsuario);
    }
}
