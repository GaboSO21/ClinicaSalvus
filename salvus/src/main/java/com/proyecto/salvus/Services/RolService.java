package com.proyecto.salvus.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.salvus.Models.Rol;
import com.proyecto.salvus.Repositories.RolRepository;

@Service
public class RolService {
    
    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    
    public List<Rol> selectRols(){
        return (List<Rol>) rolRepository.findAll();
    }
    
}
