package com.asistencia.api.repository;

import com.asistencia.api.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository ya trae listar (findAll), obtener (findById),
// guardar (save) y eliminar (deleteById). No hay que escribir SQL.
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
