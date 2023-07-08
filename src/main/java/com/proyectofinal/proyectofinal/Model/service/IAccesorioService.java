package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import com.proyectofinal.proyectofinal.Model.entidad.Accesorio;

public interface IAccesorioService {
    
    public void guardarAccesorio(Accesorio accesorio);
    public List<Accesorio> listarAccesorios();
    public String eliminarAccesorio(Long id);
}
