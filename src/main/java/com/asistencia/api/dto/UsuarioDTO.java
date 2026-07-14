package com.asistencia.api.dto;

// Datos del usuario que devolvemos tras el login (sin la contraseña)
public record UsuarioDTO(Integer idUsuario, String nombreCompleto, String rol) {
}
