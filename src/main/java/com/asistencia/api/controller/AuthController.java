package com.asistencia.api.controller;

import com.asistencia.api.dto.LoginRequest;
import com.asistencia.api.dto.UsuarioDTO;
import com.asistencia.api.model.Usuario;
import com.asistencia.api.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Login minimo para que el dashboard sepa quien entro y con que rol.
// Ruta: POST /api/auth/login  con body { "usuario": "...", "password": "..." }
//
// NOTA: por ahora compara la contraseña en texto plano (igual que el sistema actual).
// Mas adelante se puede agregar cifrado (BCrypt) y tokens (JWT).
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepo;

    public AuthController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody LoginRequest req) {
        Optional<Usuario> encontrado = usuarioRepo.findByUsuario(req.usuario());

        if (encontrado.isEmpty() || !encontrado.get().getPassword().equals(req.password())) {
            // 401 = credenciales invalidas
            return ResponseEntity.status(401).build();
        }

        Usuario u = encontrado.get();
        String rol = u.getRol() != null ? u.getRol().getNombreRol() : "";
        UsuarioDTO dto = new UsuarioDTO(u.getIdUsuario(), u.getNombreCompleto(), rol);
        return ResponseEntity.ok(dto);
    }
}
