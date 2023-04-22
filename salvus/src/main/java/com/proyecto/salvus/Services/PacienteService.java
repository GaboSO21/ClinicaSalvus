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

    public Paciente getPaciente(Paciente paciente) {
        return pacienteRepository.findById(paciente.getCedula()).orElse(null);
    }

    public Paciente getPacienteCedula(String cedula) {
        return pacienteRepository.findById(cedula).orElse(null);
    }

    public void deletePaciente(Paciente paciente) {
        pacienteRepository.delete(paciente);
    }

    public void savePaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

}
