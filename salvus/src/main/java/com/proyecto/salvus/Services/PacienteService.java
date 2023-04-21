package com.proyecto.salvus.Services;

import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.Paciente;
import com.proyecto.salvus.Repositories.PacienteRepository;

import java.util.*;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> selectPacientes() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    public Paciente getServicio(Paciente paciente) {
        return pacienteRepository.findById(paciente.getCedula()).orElse(null);
    }

    public void deletePaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    public void saveServicio(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

}
