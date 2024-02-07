package com.example.pruebaTecnica.historial;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HistorialRepository extends JpaRepository<Historial, Long> {
    Optional<Historial> findHistorialById(Long id);

    @Query("SELECT h.placa, COUNT(h.placa) AS totalRegistros " +
            "FROM Historial h " +
            "WHERE h.idParqueadero = :idParqueadero "+
            "GROUP BY h.idParqueadero " +
            "ORDER BY totalRegistros DESC LIMIT 10")
    List<Object[]> findTop10Vehiculos(Long idParqueadero);

    @Query("SELECT rp FROM Historial rp WHERE rp.placa LIKE %:placa%")
    List<Historial> findByPlacaContaining(@Param("placa") String placa);
}
