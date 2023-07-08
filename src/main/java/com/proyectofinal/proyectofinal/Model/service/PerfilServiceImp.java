package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.proyectofinal.Model.dao.IPerfilDAO;
import com.proyectofinal.proyectofinal.Model.entidad.Perfil;

@Service
public class PerfilServiceImp implements IPerfilService{
    
    @Autowired
    private IPerfilDAO perfilDAO;

    @Override
    public void registrarPerfil(Perfil perfil) {
        perfilDAO.save(perfil);
    }

    @Override
    public List<Perfil> listarPerfil() {
        return (List<Perfil>)perfilDAO.findAll();
    }

    @Override
    public void eliminarPerfil(Long id) {
        perfilDAO.deleteById(id);
    }

    @Override
    public Perfil buscarPerfil(Long id) {
        return perfilDAO.findById(id).orElse(null);
    }

}
