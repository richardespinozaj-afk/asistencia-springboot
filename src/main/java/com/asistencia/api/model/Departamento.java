package com.asistencia.api.model;

import jakarta.persistence.*;

// Entidad que representa la tabla "departamentos"
@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    private String nombre;
    private String descripcion;
    private String responsable;

    public Integer getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Integer v) { this.idDepartamento = v; }

    public String getNombre() { return nombre; }
    public void setNombre(String v) { this.nombre = v; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String v) { this.descripcion = v; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String v) { this.responsable = v; }
}
