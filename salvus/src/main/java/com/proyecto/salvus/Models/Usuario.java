package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Paciente cedula;

    private String contrasenna;

    public Usuario() {

    }

    public Usuario(Paciente cedula, String contrasenna) {
        this.cedula = cedula;
        this.contrasenna = contrasenna;
    }

    public Usuario(int idUsuario, Paciente cedula, String contrasenna) {
        this.idUsuario = idUsuario;
        this.cedula = cedula;
        this.contrasenna = contrasenna;
    }

}
