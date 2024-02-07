package com.example.pruebaTecnica.vehiculo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> getVehiculos(){
        return this.vehiculoService.getVehiculos();
    }

    @PostMapping
    public ResponseEntity<Object> registerVehiculos(@RequestBody Vehiculo vehiculo){
       return this.vehiculoService.newVehiculo(vehiculo);
    }
}
