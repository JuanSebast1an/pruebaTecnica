package com.example.pruebaTecnica.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> getVehiculos(){
        return this.vehiculoRepository.findAll();
    }

    public ResponseEntity<Object> newVehiculo(Vehiculo vehiculo) {
        Optional<Vehiculo> res = vehiculoRepository.findVehiculoByPlaca(vehiculo.getPlaca());
        HashMap<String, Object> datos= new HashMap<>();
        vehiculo.setEstado("inactivo");

    if (vehiculo.getPlaca().length() < 6 || vehiculo.getPlaca().length() > 6) {
            datos.put("message","la longitud no es correcta");
            return new ResponseEntity<>(
                datos,
                HttpStatus.CONFLICT
            );
        }

        if(res.isPresent()){
            datos.put("message","Se actualizó el estado");
            vehiculo.setEstado("activo");

        }

        vehiculoRepository.save(vehiculo);
        datos.put("data",vehiculo);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
}
