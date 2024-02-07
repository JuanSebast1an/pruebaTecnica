package com.example.pruebaTecnica.historial;


import com.example.pruebaTecnica.parqueadero.Parqueadero;
import com.example.pruebaTecnica.vehiculo.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/historial")
public class HistorialController {

    private final HistorialService historialService;

    @Autowired
    public HistorialController(HistorialService historialService){
        this.historialService = historialService;
    }

    @GetMapping
    public List<Historial> getHistoriales(){
        return this.historialService.getHistoriales();
    }

    @PostMapping
    public ResponseEntity<Object> registreIngreso(IngresoDTO ingresoDTO){
        return this.historialService.registreIngreso(ingresoDTO);
    }

    @PostMapping
    public ResponseEntity<Object> registreSalida(IngresoDTO ingresoDTO){
        return this.historialService.registreSalida(ingresoDTO);
    }

    @GetMapping("/top10/{idParqueadero}")
    public List<Object[]> obtenerTop10Vehiculos(@PathVariable Long idParqueadero) {
        return historialService.obtenerTop10Vehiculos(idParqueadero);
    }

    @GetMapping("/buscarPorPlaca")
    public ResponseEntity<List<Historial>> buscarPorCoincidenciaPlaca(@RequestParam String placa) {
        List<Historial> vehiculos = historialService.buscarPorCoincidenciaPlaca(placa);
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }
}
