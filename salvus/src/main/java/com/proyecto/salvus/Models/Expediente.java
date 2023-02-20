package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Expediente")
public class Expediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExpediente;

    private String antecedentes;
    private String motivoConsulta;

    @OneToOne(mappedBy = "idExpediente")
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDiagnostico", referencedColumnName = "idDiagnostico")
    private Diagnostico idDiagnostico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSignos", referencedColumnName = "idSignos")
    private SignoVital idSignos;

    public Expediente() {
    }

    public Expediente(String antecedentes, String motivoConsulta, Paciente paciente, Diagnostico idDiagnostico,
            SignoVital idSignos) {
        this.antecedentes = antecedentes;
        this.motivoConsulta = motivoConsulta;
        this.paciente = paciente;
        this.idDiagnostico = idDiagnostico;
        this.idSignos = idSignos;
    }

    public Expediente(int idExpediente, String antecedentes, String motivoConsulta, Paciente paciente,
            Diagnostico idDiagnostico, SignoVital idSignos) {
        this.idExpediente = idExpediente;
        this.antecedentes = antecedentes;
        this.motivoConsulta = motivoConsulta;
        this.paciente = paciente;
        this.idDiagnostico = idDiagnostico;
        this.idSignos = idSignos;
    }

}
