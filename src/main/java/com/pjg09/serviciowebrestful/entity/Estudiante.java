package com.pjg09.serviciowebrestful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity // Indica que esta clase es una tabla en la base de datos
@Table(name = "estudiantes") // Nombre de la tabla en la base de datos
public class Estudiante {
 
    @Id
    @Pattern(regexp = "^\\d{9}$", message = "El ID debe contener exactamente 9 digitos")
    @Column(nullable = false, unique = true, length = 9)
    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La carrera no puede estar vacia")
    @Column(nullable = false)
    private String carrera;

    // Constructor vacío requerido por JPA
    public Estudiante() {}

    // Constructor con parametros
    public Estudiante(String id, String nombre, String carrera) {

        setId(id);
        setNombre(nombre);
        setCarrera(carrera);

    }

    // Accesores
    public String getId() {

        return id;

    }

    public String getNombre() {

        return nombre;

    }

    public String getCarrera() {

        return carrera;

    }

    public void setId(String id) {
        
        if (id == null || !id.matches("^\\d{9}$")) {

            throw new IllegalArgumentException("El ID debe contener exactamente 9 dígitos");

        }

        this.id = id;

    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {

            throw new IllegalArgumentException("El nombre no puede estar vacío");

        }

        this.nombre = nombre;

    }

    public void setCarrera(String carrera) {

        if (carrera == null || carrera.trim().isEmpty()) {

            throw new IllegalArgumentException("La carrera no puede estar vacía");

        }

        this.carrera = carrera;

    }

    // toString para facilitar el debugging
    @Override
    public String toString() {

        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';

    }

}