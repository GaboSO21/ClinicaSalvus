package com.proyecto.salvus.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

}