
package com.proyecto.salvus.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.salvus.Models.*;
import com.proyecto.salvus.Services.*;

@Controller
public class UsuarioController {

    private PacienteService pacienteService;
    private UsuarioService usuarioService;

    public UsuarioController(PacienteService pacienteService, UsuarioService usuarioService) {
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario")
    public String inicio(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Paciente paciente = pacienteService.getPacienteCedula(auth.getName().toString());

        model.addAttribute("usuario", paciente);
        model.addAttribute("expediente", paciente.getIdExpediente());
        model.addAttribute("signos", paciente.getIdExpediente().getIdSignos());
        model.addAttribute("diagnostico", paciente.getIdExpediente().getIdDiagnostico());

        return "/usuarios/usuario";
    }

    @PostMapping("/usuario/guardar")
    public String agregar(Usuario usuario) {
        var encoder = new BCryptPasswordEncoder();
        usuario.setContrasenna( encoder.encode(usuario.getContrasenna()) );
        usuarioService.saveUser(usuario);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String eliminar(Usuario usuario) {
        usuarioService.deleteUser(usuario);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/usuario/editar/{idUsuario}")
    public String editar(Usuario usuario, Model model) {
        usuario = usuarioService.getUser(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("rol", usuario.getIdRol().getIdRol());
        return "Admin/editarUsuarioAdmin";
    }

}
