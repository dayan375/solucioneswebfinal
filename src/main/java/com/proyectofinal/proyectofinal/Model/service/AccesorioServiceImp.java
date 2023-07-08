package com.proyectofinal.proyectofinal.Model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectofinal.proyectofinal.Model.dao.IAccesorioDAO;
import com.proyectofinal.proyectofinal.Model.entidad.Accesorio;

@Service
public class AccesorioServiceImp implements IAccesorioService {

    @Autowired
    private IAccesorioDAO accesorioDAO;

    @Override
    public void guardarAccesorio(Accesorio accesorio) {
        accesorioDAO.save(accesorio);
    }

    @Override
    public List<Accesorio> listarAccesorios() {
        return accesorioDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public String eliminarAccesorio(Long id) {
        String rpta = "";
        try{
            accesorioDAO.deleteById(id);
            rpta = "Se eliminó el producto correctamente";
        }catch(Exception e ){
            rpta = e.getMessage();
        }
        return rpta;
    }

}
