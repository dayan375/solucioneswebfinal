package com.proyectofinal.proyectofinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectofinal.proyectofinal.Model.entidad.Perfil;
import com.proyectofinal.proyectofinal.Model.service.IPerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
    
    @Autowired
    private IPerfilService perfilService;

    @GetMapping("/")
    public String inicio(Model model){
        Perfil perfil = new Perfil();
        model.addAttribute("perfil", perfil);
        model.addAttribute("titulo", "Registrar nuevo Perfil");
        model.addAttribute("listaPerfiles", perfilService.listarPerfil());
        return "perfil/index";
    }

    @GetMapping("/registrar")
    public String registrar(Perfil perfil){
        perfilService.registrarPerfil(perfil);
        return "redirect:/perfil/";
    }

     @GetMapping("mostrarEditar/{id}")
    public String editar(@PathVariable Long id, Model model){
        Perfil perfil = new Perfil();
        perfil = perfilService.buscarPerfil(id);
        model.addAttribute("perfil", perfil);
        model.addAttribute("titulo", "Modificar Perfil");
        model.addAttribute("listaPerfiles", perfilService.listarPerfil());
        return "perfil/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        perfilService.eliminarPerfil(id);
        return "redirect:/perfil/";
    }
}
