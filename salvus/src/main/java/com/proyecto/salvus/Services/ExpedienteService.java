package com.proyecto.salvus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.SignoVital;
import com.proyecto.salvus.Models.Doctor;
import com.proyecto.salvus.Models.Expediente;
import com.proyecto.salvus.Repositories.ExpedienteRepository;
import com.proyecto.salvus.Repositories.SignosRepository;

import java.util.*;

@Service
public class ExpedienteService {

    @Autowired
    private ExpedienteRepository expedienteRepository;

    public ExpedienteService(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    public List<Expediente> selectExpedientes() {
        return (List<Expediente>) expedienteRepository.findAll();
    }

    public Expediente getExpediente(Expediente expediente) {
        return expedienteRepository.findById(expediente.getIdExpediente()).orElse(null);
    }

    public void deleteExpediente(Expediente expediente) {
        expedienteRepository.delete(expediente);
    }

    public void saveExpediente(Expediente expediente) {
        expedienteRepository.save(expediente);
    }

}
