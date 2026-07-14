package com.asistencia.api.model;

import jakarta.persistence.*;

// Entidad que representa la tabla "roles"
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    public Integer getIdRol() { return idRol; }
    public String getNombreRol() { return nombreRol; }
}
