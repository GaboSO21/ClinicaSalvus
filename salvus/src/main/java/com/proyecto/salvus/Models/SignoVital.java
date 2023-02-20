package com.proyecto.salvus.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SignoVitale")
public class SignoVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSignos;

    private float imc, frecCardiaca, frecRespiratoria, temperatura, peso, tensionArterial;

    @OneToOne(mappedBy = "idSignos")
    private Expediente expediente;

    public SignoVital() {
    }

    public SignoVital(float imc, float frecCardiaca, float frecRespiratoria, float temperatura, float peso,
            float tensionArterial, Expediente expediente) {
        this.imc = imc;
        this.frecCardiaca = frecCardiaca;
        this.frecRespiratoria = frecRespiratoria;
        this.temperatura = temperatura;
        this.peso = peso;
        this.tensionArterial = tensionArterial;
        this.expediente = expediente;
    }

    public SignoVital(int idSignos, float imc, float frecCardiaca, float frecRespiratoria, float temperatura,
            float peso, float tensionArterial, Expediente expediente) {
        this.idSignos = idSignos;
        this.imc = imc;
        this.frecCardiaca = frecCardiaca;
        this.frecRespiratoria = frecRespiratoria;
        this.temperatura = temperatura;
        this.peso = peso;
        this.tensionArterial = tensionArterial;
        this.expediente = expediente;
    }

}
