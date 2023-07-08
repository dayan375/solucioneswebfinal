package com.proyectofinal.proyectofinal.Model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyectofinal.proyectofinal.Model.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
    
    public List<Usuario> findAllByOrderByNombreAsc();
}
