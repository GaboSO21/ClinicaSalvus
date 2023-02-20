package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    private String conclusion, pronostico, tratamiento, seguimiento;

    @OneToOne(mappedBy = "idDiagnostico")
    private Expediente expediente;

    public Diagnostico() {
    }

    public Diagnostico(String conclusion, String pronostico, String tratamiento, String seguimiento,
            Expediente expediente) {
        this.conclusion = conclusion;
        this.pronostico = pronostico;
        this.tratamiento = tratamiento;
        this.seguimiento = seguimiento;
        this.expediente = expediente;
    }

    public Diagnostico(int idDiagnostico, String conclusion, String pronostico, String tratamiento, String seguimiento,
            Expediente expediente) {
        this.idDiagnostico = idDiagnostico;
        this.conclusion = conclusion;
        this.pronostico = pronostico;
        this.tratamiento = tratamiento;
        this.seguimiento = seguimiento;
        this.expediente = expediente;
    }

}
