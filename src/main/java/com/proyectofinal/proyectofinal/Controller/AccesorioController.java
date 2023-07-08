package com.proyectofinal.proyectofinal.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectofinal.proyectofinal.Model.entidad.Accesorio;
import com.proyectofinal.proyectofinal.Model.service.IAccesorioService;
import com.proyectofinal.proyectofinal.Model.service.ICategoriaService;

@Controller
@RequestMapping("/accesorio")
public class AccesorioController {
    
    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IAccesorioService accesorioService;

    @GetMapping("/")
    public String inicio(Model model){

        Accesorio accesorio = new Accesorio();
        model.addAttribute("accesorio", accesorio);

        model.addAttribute("listaAccesorios", accesorioService.listarAccesorios());

        model.addAttribute("listaCategorias", categoriaService.mostrarCatOrdenAsc());
        return "accesorio/index";
    }

    @PostMapping("/form")
    public String guardar(Accesorio accesorio){
        accesorioService.guardarAccesorio(accesorio);
        return "redirect:/accesorio/";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model, RedirectAttributes flash){
        String rpta = accesorioService.eliminarAccesorio(id);
        flash.addAttribute("mensaje", rpta);
        return "redirect:/accesorio/";
    }

}
