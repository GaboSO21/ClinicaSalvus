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

    private String username;

    private String contrasenna;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    private Rol idRol;

    public Usuario() {

    }

    public Usuario(String username, String contrasenna) {
        this.username = username;
        this.contrasenna = contrasenna;
    }

    public Usuario(int idUsuario, String username, String contrasenna) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.contrasenna = contrasenna;
    }

}
