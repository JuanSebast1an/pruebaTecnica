package com.example.pruebaTecnica.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsuarioSuper implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuarioSuper= new Usuario();
        usuarioSuper.setRol("admin");
        usuarioSuper.setPassWord("admin");
        usuarioSuper.setUserName("admin@mail.com");
        usuarioRepository.save(usuarioSuper);
    }
}
