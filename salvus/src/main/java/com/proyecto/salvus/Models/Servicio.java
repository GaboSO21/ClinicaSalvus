package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicio;

    private String nombre;
    private String descripcion;

    public Servicio() {

    }

    public Servicio(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Servicio(int idServicio, String nombre, String descripcion) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
