package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    @GetMapping("/listado")
    public String listar() {
        return "contacto";
    }

}