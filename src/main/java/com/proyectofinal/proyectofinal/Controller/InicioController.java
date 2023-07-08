package com.proyectofinal.proyectofinal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/panel/")
    public String panel(){
        return "panel";
    }
}