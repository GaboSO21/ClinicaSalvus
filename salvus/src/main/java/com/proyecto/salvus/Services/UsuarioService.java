package com.proyecto.salvus.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.salvus.Models.Usuario;
import com.proyecto.salvus.Repositories.UsuarioRepository;


@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(user.getIdRol().getNombre()));

        return new User(user.getUsername(), user.getContrasenna(), roles);
    }

    public List<Usuario> selectUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public void saveUser(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUser(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
    
    public Usuario getUser(Usuario usuario) {
        return usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
    }

}
