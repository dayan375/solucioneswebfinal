package com.proyectofinal.proyectofinal.Model.dao;

import org.springframework.data.repository.CrudRepository;
import com.proyectofinal.proyectofinal.Model.entidad.Persona;

public interface IPersonaDAO extends CrudRepository<Persona, Long> {
    public Persona findByUsername(String username);
}
