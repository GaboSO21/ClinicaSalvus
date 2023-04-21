
package com.proyecto.salvus.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.salvus.Models.*;
import com.proyecto.salvus.Services.*;

@Controller
public class AdministradorController {

    private DoctorService doctorService;
    private ServicioService servicioService;

    public AdministradorController(DoctorService doctorService, ServicioService servicioService) {
        this.doctorService = doctorService;
        this.servicioService = servicioService;
    }

    @GetMapping("/admin")
    public String inicio() {

        return "Admin/indexAdmin";
    }

    @GetMapping("/admin/pacientes")
    public String pacientes() {

        return "Admin/pacienteAdmin";
    }

    @GetMapping("/admin/doctores")
    public String doctores(Model model) {
        model.addAttribute("doctores", doctorService.selectDoctores());
        return "Admin/doctoresAdmin";
    }

    @GetMapping("/admin/servicios")
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.selectServicios());
        return "Admin/serviciosAdmin";
    }

}
