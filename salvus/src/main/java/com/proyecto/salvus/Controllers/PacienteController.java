package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.Paciente;
import com.proyecto.salvus.Services.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService PacienteService;

    public PacienteController(PacienteService PacienteService) {
        this.PacienteService = PacienteService;
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminar(Paciente paciente) {
        PacienteService.deletePaciente(paciente);
        return "redirect:/admin/pacientes";
    }

    @GetMapping("/editar/{cedula}")
    public String editar(Paciente paciente, Model model) {
        paciente = PacienteService.getPaciente(paciente);
        model.addAttribute("paciente", paciente);
        model.addAttribute("idExpediente", paciente.getIdExpediente().getIdExpediente());
        return "Admin/editarPacienteAdmin";
    }

    @PostMapping("/guardar")
    public String agregar(Paciente paciente) {
        PacienteService.savePaciente(paciente);
        return "redirect:/admin/pacientes";
    }

}
