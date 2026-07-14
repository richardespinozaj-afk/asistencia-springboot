package com.asistencia.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Punto de entrada de la aplicacion Spring Boot.
// Al ejecutar esta clase se levanta un servidor Tomcat embebido en el puerto 8081.
@SpringBootApplication
public class AsistenciaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsistenciaApiApplication.class, args);
    }
}
