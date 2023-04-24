package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.Diagnostico;
import com.proyecto.salvus.Services.DiagnosticoService;

@Controller
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    private DiagnosticoService DiagnosticoService;

    public DiagnosticoController(DiagnosticoService DiagnosticoService) {
        this.DiagnosticoService = DiagnosticoService;
    }

    @GetMapping("/editar/{idDiagnostico}")
    public String editar(Diagnostico Diagnostico, Model model) {
        model.addAttribute("diagnostico", DiagnosticoService.getDiagnostico(Diagnostico));
        return "Admin/editarDiagnosticoAdmin";
    }

    @PostMapping("/guardar")
    public String agregar(Diagnostico Diagnostico) {
        DiagnosticoService.saveDiagnostico(Diagnostico);
        return "redirect:/admin/pacientes";
    }

}
