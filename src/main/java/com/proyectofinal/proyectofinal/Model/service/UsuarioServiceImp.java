package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.proyectofinal.Model.dao.IUsuarioDAO;
import com.proyectofinal.proyectofinal.Model.entidad.Usuario;

@Service
public class UsuarioServiceImp implements IUsuarioService {
    
    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public String eliminarUsuario(Long id) {
        String rpta = "";
        try{
            usuarioDAO.deleteById(id);
            rpta = "Se elimino el Usuario correctamente";
        }catch(Exception e){
            rpta = e.getMessage();
        }
        return rpta;
    }
}
