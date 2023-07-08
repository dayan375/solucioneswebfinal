package com.proyectofinal.proyectofinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectofinal.proyectofinal.Model.entidad.Categoria;
import com.proyectofinal.proyectofinal.Model.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/")
    public String inicio(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo", "Registrar Nueva Categoria");
        model.addAttribute("listaCategorias", categoriaService.mostrarCategorias());
        return "categoria/index";
    }
    
    @GetMapping("/guardar")
    public String guardar(Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categoria/";
    }

    @GetMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable Long id, Model model){
        Categoria categoria = new Categoria();
        categoria = categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo", "Modificar Categoria");
        model.addAttribute("listaCategorias", categoriaService.mostrarCategorias());
        return "categoria/index";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/";
    }

}