package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Paciente")
public class Paciente {

    @Id
    private String cedula;

    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private int edad;
    private String sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idExpediente", referencedColumnName = "idExpediente")
    private Expediente idExpediente;

    public Paciente() {
    }

    public Paciente(String nombre, String direccion, int edad, String sexo, String telefono, Expediente idExpediente, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.sexo = sexo;
        this.idExpediente = idExpediente;
        this.correo = correo;
    }

    public Paciente(String cedula, String nombre, String direccion, int edad, String sexo, String telefono,
            Expediente idExpediente, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.sexo = sexo;
        this.idExpediente = idExpediente;
        this.correo = correo;
    }

}
