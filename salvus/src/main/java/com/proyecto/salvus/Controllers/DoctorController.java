package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.salvus.Models.Doctor;
import com.proyecto.salvus.Services.DoctorService;

@Controller
@RequestMapping("/doctores")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("doctores", doctorService.selectDoctores());
        return "medicos/personal-medico";
    }

    @GetMapping("/eliminar/{idDoctor}")
    public String eliminar(Doctor doctor) {
        doctorService.deleteDoctor(doctor);
        return "redirect:/listado";
    }

    @GetMapping("/editar/{idDoctor}")
    public String editar(Doctor doctor, Model model) {
        model.addAttribute("doctor", doctorService.getDoctor(doctor));
        return "agregar-medico";
    }

    @PostMapping("/guardar")
    public String agregar(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/listado";
    }

}
