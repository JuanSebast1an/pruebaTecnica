package com.example.pruebaTecnica.parqueadero;

import com.example.pruebaTecnica.parqueadero.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "api/v1/parqueaderos")
public class ParqueaderoController {

    private final ParqueaderoService parqueaderoService;

    @Autowired
    public ParqueaderoController(ParqueaderoService parqueaderoService){
        this.parqueaderoService = parqueaderoService;
    }

    @GetMapping
    public List<Parqueadero> getParqueaderos(){
        return this.parqueaderoService.getParqueaderos();
    }

    @PostMapping
    public ResponseEntity<Object> registerParqueaderos(@RequestBody Parqueadero parqueadero){
        return this.parqueaderoService.newParqueadero(parqueadero);
    }

    @GetMapping("/parqueaderos/{idSocio}")
    public List<Object[]> parqeuaderosSocio(@PathVariable Long idSocio) {
        return parqueaderoService.parqueaderosSocio(idSocio);
    }


}
