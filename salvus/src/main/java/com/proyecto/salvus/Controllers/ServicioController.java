package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.Servicio;
import com.proyecto.salvus.Services.ServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("servicio", servicioService.selectServicios());
        return "servicios/servicios-medicos";
    }

    @GetMapping("/eliminar/{idDoctor}")
    public String eliminar(Servicio servicio) {
        servicioService.deleteServicio(servicio);
        return "redirect:/listado";
    }

    @GetMapping("/editar/{idDoctor}")
    public String editar(Servicio servicio, Model model) {
        model.addAttribute("doctor", servicioService.getServicio(servicio));
        return "agregar";
    }

    @PostMapping("/guardar")
    public String agregar(Servicio servicio) {
        servicioService.saveServicio(servicio);
        return "redirect:/listado";
    }

}
