package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.Expediente;
import com.proyecto.salvus.Services.ExpedienteService;

@Controller
@RequestMapping("/expediente")
public class ExpedienteController {

    private ExpedienteService expedienteService;

    public ExpedienteController(ExpedienteService expedienteService) {
        this.expedienteService = expedienteService;
    }

    @GetMapping("/editar/{idExpediente}")
    public String editar(Expediente expediente, Model model) {
        model.addAttribute("expediente", expedienteService.getExpediente(expediente));
        return "agregar";
    }

    @PostMapping("/guardar")
    public String agregar(Expediente expediente) {
        expedienteService.saveExpediente(expediente);
        return "redirect:/admin/pacientes";
    }

}
