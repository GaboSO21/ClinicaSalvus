package com.proyecto.salvus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.Diagnostico;
import com.proyecto.salvus.Models.Doctor;
import com.proyecto.salvus.Repositories.DiagnosticoRepository;
import com.proyecto.salvus.Repositories.DiagnosticoRepository;

import java.util.*;

@Service
public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository DiagnosticoRepository;

    public DiagnosticoService(DiagnosticoRepository DiagnosticoRepository) {
        this.DiagnosticoRepository = DiagnosticoRepository;
    }

    public List<Diagnostico> selectDiagnosticos() {
        return (List<Diagnostico>) DiagnosticoRepository.findAll();
    }

    public Diagnostico getDiagnostico(Diagnostico diagnostico) {
        return DiagnosticoRepository.findById(diagnostico.getIdDiagnostico()).orElse(null);
    }

    public void deleteDiagnostico(Diagnostico diagnostico) {
        DiagnosticoRepository.delete(diagnostico);
    }

    public void saveDiagnostico(Diagnostico diagnostico) {
        DiagnosticoRepository.save(diagnostico);
    }

}
