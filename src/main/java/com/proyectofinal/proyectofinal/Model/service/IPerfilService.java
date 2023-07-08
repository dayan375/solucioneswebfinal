package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import com.proyectofinal.proyectofinal.Model.entidad.Perfil;

public interface IPerfilService {
    
    //Registrar Perfil
    public void registrarPerfil(Perfil perfil);

    //Listar Perfil
    public List<Perfil> listarPerfil();

    //Eliminar Perfil
    public void eliminarPerfil(Long id);

    //Buscar Perfil
    public Perfil buscarPerfil(Long id);

}
