package com.proyectofinal.proyectofinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyectofinal.proyectofinal.Model.entidad.Usuario;
import com.proyectofinal.proyectofinal.Model.service.IPerfilService;
import com.proyectofinal.proyectofinal.Model.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private IPerfilService perfilService;
    
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model){

        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        model.addAttribute("listaUsuarios", usuarioService.listarUsuarios());

        model.addAttribute("listaPerfiles", perfilService.listarPerfil());

        return "usuario/index";
    }

    @PostMapping("/form")
    public String guardar(Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuario/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model, RedirectAttributes flash){
        String rpta = usuarioService.eliminarUsuario(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/usuario/";
    } 


}
