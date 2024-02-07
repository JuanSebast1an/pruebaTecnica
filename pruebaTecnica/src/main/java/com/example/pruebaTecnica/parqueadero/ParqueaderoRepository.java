package com.example.pruebaTecnica.parqueadero;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long> {

    Optional<Parqueadero> findParqueaderoById(Long id);

    @Query("SELECT p " +
            "FROM Parqueadero p " +
            "WHERE p.idSocio = :idSocio ")
    List<Object[]> findByIdSocio(Long idSocio);


}
