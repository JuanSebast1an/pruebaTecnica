package com.example.pruebaTecnica.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios(){
        return this.usuarioRepository.findAll();
    }

    public void newUsuario(Usuario usuario) {
        Optional<Usuario> res = usuarioRepository.findUsuarioByUserName(usuario.getUsername());

        if(res.isPresent()){
            throw new IllegalStateException("Ya exite ese usuario");
        }

        usuarioRepository.save(usuario);

    }
}
