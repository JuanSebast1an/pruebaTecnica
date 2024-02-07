package com.example.pruebaTecnica.vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {

    Optional<Vehiculo> findVehiculoByPlaca(String placa);
}
