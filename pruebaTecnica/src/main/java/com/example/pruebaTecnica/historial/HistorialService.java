package com.example.pruebaTecnica.historial;


import com.example.pruebaTecnica.parqueadero.Parqueadero;
import com.example.pruebaTecnica.parqueadero.ParqueaderoRepository;
import com.example.pruebaTecnica.vehiculo.Vehiculo;
import com.example.pruebaTecnica.vehiculo.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialService {

    private final HistorialRepository historialRepository;
    private final VehiculoRepository vehiculoRepository;
    private final ParqueaderoRepository parqueaderoRepository;

    @Autowired
    public HistorialService(HistorialRepository historialRepository, VehiculoRepository vehiculoRepository, ParqueaderoRepository parqueaderoRepository){
        this.historialRepository = historialRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.parqueaderoRepository = parqueaderoRepository;
    }

    public List<Historial> getHistoriales(){
        return this.historialRepository.findAll();
    }

    public ResponseEntity<Object> registreIngreso(IngresoDTO ingresoDTO) {
        Optional<Historial> res = historialRepository.findHistorialById(ingresoDTO.getHistorial().getId());
        Optional<Vehiculo> res2 = vehiculoRepository.findVehiculoByPlaca(ingresoDTO.getVehiculo().getPlaca());
        HashMap<String, Object> datos = new HashMap<>();

        if (res.isPresent()) {
            datos.put("error", true);
            datos.put("message", "El historial ya existe");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        if (res2.isPresent() && ingresoDTO.getVehiculo().getEstado().equals("activo")) {
            datos.put("error", true);
            datos.put("message", "No se puede Registrar Ingreso, ya existe la placa en este u otro parqueadero");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }

        ingresoDTO.getHistorial().setHoraInicio(LocalDateTime.now());
        ingresoDTO.getVehiculo().setEstado("activo");

        vehiculoRepository.save(ingresoDTO.getVehiculo());
        historialRepository.save(ingresoDTO.getHistorial());
        datos.put("data", ingresoDTO.getHistorial());
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

        public ResponseEntity<Object> registreSalida(IngresoDTO ingresoDTO) {
            Optional<Historial> res = historialRepository.findHistorialById(ingresoDTO.getHistorial().getId());
            Optional<Vehiculo> res2 = vehiculoRepository.findVehiculoByPlaca(ingresoDTO.getVehiculo().getPlaca());
            HashMap<String, Object> datos= new HashMap<>();

            if(!res.isPresent()){
                datos.put("error", true);
                datos.put("message","El historial No existe");
                return new ResponseEntity<>(
                        datos,
                        HttpStatus.CONFLICT
                );
            }

            if(res2.isPresent() && ingresoDTO.getVehiculo().getEstado().equals("inactivo")){
                datos.put("error", true);
                datos.put("message","No se puede Registrar Salida, no existe la placa en el parqueadero");
                return new ResponseEntity<>(
                        datos,
                        HttpStatus.CONFLICT
                );
            }

            ingresoDTO.getHistorial().setHoraFin(LocalDateTime.now());
            Duration diferencia = Duration.between(ingresoDTO.getHistorial().getHoraInicio(), ingresoDTO.getHistorial().getHoraFin());

            long horas = diferencia.toHours();

            ingresoDTO.getHistorial().setTotal((int) (horas*ingresoDTO.getParqueadero().getCostoHora()));

            ingresoDTO.getVehiculo().setEstado("inactivo");

            vehiculoRepository.save(ingresoDTO.getVehiculo());
            historialRepository.save(ingresoDTO.getHistorial());
            datos.put("data",ingresoDTO.getHistorial());
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CREATED
            );

    }

    public List<Object[]> obtenerTop10Vehiculos(Long idParqueadero) {
        return historialRepository.findTop10Vehiculos(idParqueadero);
    }

    public List<Historial> buscarPorCoincidenciaPlaca(String placa) {
        return historialRepository.findByPlacaContaining(placa);
    }
}
