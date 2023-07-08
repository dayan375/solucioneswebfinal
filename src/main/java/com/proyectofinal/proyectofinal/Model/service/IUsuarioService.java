package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import com.proyectofinal.proyectofinal.Model.entidad.Usuario;

public interface IUsuarioService {
    
    public void guardarUsuario(Usuario usuario);

    public List<Usuario> listarUsuarios();

    public String eliminarUsuario(Long id);
}
