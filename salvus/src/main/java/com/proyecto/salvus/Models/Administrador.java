package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrador;

    private String usuario;
    private String contrasenna;

    public Administrador() {

    }

    public Administrador(String usuario, String contrasenna) {
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

    public Administrador(int idAdministrador, String usuario, String contrasenna) {
        this.idAdministrador = idAdministrador;
        this.usuario = usuario;
        this.contrasenna = contrasenna;
    }

}
