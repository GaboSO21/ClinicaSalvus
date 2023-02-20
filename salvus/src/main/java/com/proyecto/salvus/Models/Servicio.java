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
    
}
