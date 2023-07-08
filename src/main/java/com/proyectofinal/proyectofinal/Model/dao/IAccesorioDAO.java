package com.proyectofinal.proyectofinal.Model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyectofinal.proyectofinal.Model.entidad.Accesorio;

public interface IAccesorioDAO extends CrudRepository<Accesorio, Long> {
    
    public List<Accesorio> findAllByOrderByNombreAsc();
}
