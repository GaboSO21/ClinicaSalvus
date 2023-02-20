package com.proyecto.salvus.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.salvus.Models.SignoVital;

public interface SignosRepository extends CrudRepository<SignoVital, Integer> {
    
}
