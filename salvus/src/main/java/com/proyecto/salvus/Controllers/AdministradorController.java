
package com.proyecto.salvus.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.salvus.Services.*;

@Controller
public class AdministradorController {

    private DoctorService doctorService;
    private ServicioService servicioService;
    private PacienteService pacienteService;
    private UsuarioService usuarioService;
    private SignoVitalService signoVitalService;
    private RolService rolService;

    public AdministradorController(DoctorService doctorService, ServicioService servicioService,
            PacienteService pacienteService, UsuarioService usuarioService, SignoVitalService signoVitalService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.doctorService = doctorService;
        this.servicioService = servicioService;
        this.pacienteService = pacienteService;
        this.signoVitalService = signoVitalService;
        this.rolService = rolService;
    }

    @GetMapping("/admin")
    public String inicio() {

        return "Admin/indexAdmin";
    }

    @GetMapping("/admin/pacientes")
    public String pacientes(Model model) {
        var pacientes = pacienteService.selectPacientes();
        var signos = signoVitalService.selectSignoVitals();
        int next = (signos.get(signos.size()-1).getIdSignos()) + 1;
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("next", next);
        System.out.println(next);
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

    @GetMapping("/admin/usuarios")
    public String listarUsuarios(Model model) {
        long adminRol = 1;
        long userRol = 2;
        model.addAttribute("usuarios", usuarioService.selectUsuarios());
        model.addAttribute("userRol", userRol);
        model.addAttribute("adminRol", adminRol);
        return "Admin/usuarioAdmin";
    }

}
