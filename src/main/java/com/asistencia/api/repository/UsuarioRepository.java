package com.asistencia.api.repository;

import com.asistencia.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Spring genera automaticamente las consultas a partir del nombre de los metodos.
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Para el login: buscar por el campo "usuario"
    Optional<Usuario> findByUsuario(String usuario);
    // count() ya viene incluido en JpaRepository (total de empleados)
}
