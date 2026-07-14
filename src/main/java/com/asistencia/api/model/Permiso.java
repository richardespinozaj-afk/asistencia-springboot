package com.asistencia.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// Entidad que representa la tabla "permisos"
@Entity
@Table(name = "permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Integer idPermiso;

    @Column(name = "tipo_permiso")
    private String tipoPermiso;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    private String motivo;

    // PENDIENTE / APROBADO / RECHAZADO
    private String estado;

    @Column(name = "fecha_solicitud")
    private LocalDate fechaSolicitud;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Integer getIdPermiso() { return idPermiso; }
    public String getTipoPermiso() { return tipoPermiso; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public String getMotivo() { return motivo; }
    public String getEstado() { return estado; }
    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public Usuario getUsuario() { return usuario; }
}
