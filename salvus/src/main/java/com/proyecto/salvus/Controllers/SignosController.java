package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.SignoVital;
import com.proyecto.salvus.Services.SignoVitalService;

@Controller
@RequestMapping("/signos")
public class SignosController {

    private SignoVitalService signoVitalService;

    public SignosController(SignoVitalService signoVitalService) {
        this.signoVitalService = signoVitalService;
    }

    @GetMapping("/editar/{idSigno}")
    public String editar(SignoVital signoVital, Model model) {
        model.addAttribute("signo", signoVitalService.getSignoVital(signoVital));
        return "agregar";
    }

    @PostMapping("/guardar")
    public String agregar(SignoVital signoVital) {
        signoVitalService.saveSignoVital(signoVital);
        return "redirect:/admin/pacientes";
    }

}
