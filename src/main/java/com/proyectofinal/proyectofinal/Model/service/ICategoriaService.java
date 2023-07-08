package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import com.proyectofinal.proyectofinal.Model.entidad.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);

    //Listar 
    
    public List<Categoria> mostrarCategorias();
    public List<Categoria> mostrarCatOrdenAsc();
    public List<Categoria> mostrarLike(String p);



    public Categoria buscarCategoria(Long id);
    
    //Eliminar categoria
    public void eliminarCategoria(Long id); 

}
