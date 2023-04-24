package com.proyecto.salvus.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.salvus.Models.Mensaje;
import com.proyecto.salvus.Models.Paciente;
import com.proyecto.salvus.Services.EmailSenderService;
import com.proyecto.salvus.Services.PacienteService;

@Controller
public class ContactoController {

    private EmailSenderService emailSenderService;
    private PacienteService pacienteService;

    public ContactoController(EmailSenderService emailSenderService, PacienteService pacienteService) {
        this.emailSenderService = emailSenderService;
        this.pacienteService = pacienteService;
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviar(Mensaje mensaje) {
        mensaje.setEmail("gso2090@gmail.com");
        emailSenderService.sendEmail(mensaje.getEmail(), mensaje.getSubject(), mensaje.getBody());
        System.out.println("Mensaje enviado!...");
        return "redirect:/";
    }

    @PostMapping("/contacto/enviar/pacientes")
    public String enviarMasivo(Mensaje mensaje) {
        List<Paciente> pacientes = pacienteService.selectPacientes();
        for (Paciente paciente : pacientes) {

            mensaje.setEmail(paciente.getCorreo());
            emailSenderService.sendEmail(mensaje.getEmail(), mensaje.getSubject(), mensaje.getBody());

        }
        System.out.println("Mensaje enviado!...");
        return "redirect:/";
    }

}
