package com.proyecto.salvus.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.salvus.Models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findByUsername(String usuario);

}
