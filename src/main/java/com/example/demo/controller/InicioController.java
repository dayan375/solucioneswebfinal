package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class InicioController {

    @RequestMapping("/")
    public String inicio(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
          return "login";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
          return "dashboard";
    }

    @RequestMapping("/limpieza")
    public String limpieza(){
        return "Limpieza";
    }

    @RequestMapping("/lacteos")
    public String lacteos(){
          return "Lacteos";
    }
    @RequestMapping("/bebidas")
    public String bebidas(){
          return "bebidas";
    }

}
