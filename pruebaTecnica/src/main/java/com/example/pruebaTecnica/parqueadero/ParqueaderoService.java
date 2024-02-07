package com.example.pruebaTecnica.parqueadero;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;

    @Autowired
    public ParqueaderoService(ParqueaderoRepository parqueaderoRepository){
        this.parqueaderoRepository = parqueaderoRepository;
    }

    public List<Parqueadero> getParqueaderos(){
        return this.parqueaderoRepository.findAll();
    }

    public ResponseEntity<Object> newParqueadero(Parqueadero parqueadero) {
        Optional<Parqueadero> res = parqueaderoRepository.findParqueaderoById(parqueadero.getId());
        HashMap<String, Object> datos= new HashMap<>();

        if(res.isPresent()){
            datos.put("error", true);
            datos.put("message","El parqueadero ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        parqueaderoRepository.save(parqueadero);
        datos.put("data",parqueadero);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }

    public List<Object[]> parqueaderosSocio(Long idSocio) {
        return parqueaderoRepository.findByIdSocio(idSocio);
    }


}
