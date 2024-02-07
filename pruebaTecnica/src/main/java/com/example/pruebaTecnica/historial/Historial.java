package com.example.pruebaTecnica.historial;

import com.example.pruebaTecnica.parqueadero.Parqueadero;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@Builder
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private Long idParqueadero;

    private Integer total;

    private LocalDateTime horaInicio;

    private LocalDateTime  horaFin;

    public Historial(Long id, String placa, Long idParqueadero, Integer total, LocalDateTime  horaInicio, LocalDateTime  horaFin) {
        this.id = id;
        this.placa = placa;
        this.idParqueadero = idParqueadero;
        this.total = total;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Historial() {

    }

    public Long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(Long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public LocalDateTime  getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime  horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime  getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalDateTime  horaFin) {
        this.horaFin = horaFin;
    }
}
