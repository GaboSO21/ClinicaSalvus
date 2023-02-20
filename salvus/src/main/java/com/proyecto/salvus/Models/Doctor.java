package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoctor;

    private String nombre, primerApellido, segundoApellido;
    private String servicios, especialidades, titulos, img;

    public Doctor() {
    }

    public Doctor(String nombre, String primerApellido, String segundoApellido, String servicios, String especialidades,
            String titulos, String img) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.servicios = servicios;
        this.especialidades = especialidades;
        this.titulos = titulos;
        this.img = img;
    }

    public Doctor(int idDoctor, String nombre, String primerApellido, String segundoApellido, String servicios,
            String especialidades, String titulos, String img) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.servicios = servicios;
        this.especialidades = especialidades;
        this.titulos = titulos;
        this.img = img;
    }

}
