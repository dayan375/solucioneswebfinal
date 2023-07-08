package com.proyectofinal.proyectofinal.Model.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectofinal.proyectofinal.Model.dao.IPersonaDAO;
import com.proyectofinal.proyectofinal.Model.entidad.Persona;
import com.proyectofinal.proyectofinal.Model.entidad.Rol;

@Service("UserService")
public class UserService implements UserDetailsService{
    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona usuario = personaDAO.findByUsername(username);
        List<GrantedAuthority> listaRoles = new ArrayList<>();
        if(usuario == null){
            throw new UsernameNotFoundException("usuario / contraseña incorrecta");
        }else{
            
            for(Rol item:usuario.getRoles()){
                listaRoles.add(new SimpleGrantedAuthority(item.getAuthority()));
            }
        }
        return new User(usuario.getUsername(), usuario.getPassword(), listaRoles);
    }
    
}