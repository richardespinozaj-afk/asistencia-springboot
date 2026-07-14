package com.asistencia.api.controller;

import com.asistencia.api.model.Departamento;
import com.asistencia.api.repository.DepartamentoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CRUD de Departamentos: crear, leer, actualizar y eliminar.
// Rutas bajo /api/departamentos
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoRepository repo;

    public DepartamentoController(DepartamentoRepository repo) {
        this.repo = repo;
    }

    // LISTAR todos
    @GetMapping
    public List<Departamento> listar() {
        return repo.findAll();
    }

    // OBTENER uno por id
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtener(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREAR uno nuevo
    @PostMapping
    public Departamento crear(@RequestBody Departamento d) {
        d.setIdDepartamento(null); // aseguramos que sea inserción
        return repo.save(d);
    }

    // ACTUALIZAR uno existente
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> actualizar(@PathVariable Integer id, @RequestBody Departamento d) {
        return repo.findById(id).map(existente -> {
            existente.setNombre(d.getNombre());
            existente.setDescripcion(d.getDescripcion());
            existente.setResponsable(d.getResponsable());
            return ResponseEntity.ok(repo.save(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    // ELIMINAR uno
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        try {
            repo.deleteById(id);
            return ResponseEntity.ok("Departamento eliminado");
        } catch (DataIntegrityViolationException e) {
            // Ocurre si hay empleados asignados a este departamento (clave foránea)
            return ResponseEntity.status(409)
                    .body("No se puede eliminar: hay empleados asignados a este departamento.");
        }
    }
}
