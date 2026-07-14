package com.asistencia.api.dto;

// Datos que envia el frontend al iniciar sesion
public record LoginRequest(String usuario, String password) {
}
