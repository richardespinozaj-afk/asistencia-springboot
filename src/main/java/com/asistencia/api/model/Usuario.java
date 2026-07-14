package com.asistencia.api.model;

import jakarta.persistence.*;

// Entidad que representa la tabla "usuarios" (empleados)
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String password;

    // Relacion: cada usuario tiene un rol. EAGER para tener el nombre del rol disponible.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public Integer getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }
    public Rol getRol() { return rol; }

    // Nombre y apellido juntos, para mostrar en pantalla
    public String getNombreCompleto() { return nombre + " " + apellido; }
}
