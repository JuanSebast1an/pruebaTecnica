package com.example.pruebaTecnica.parqueadero;


import com.example.pruebaTecnica.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table
@Builder
public class Parqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer capacidad;

    private Integer costoHora;

    private Long idSocio;

    public Parqueadero(Long id, Integer capacidad, Integer costoHora, Long idSocio) {
        this.id = id;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
        this.idSocio = idSocio;
    }

    public Parqueadero() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(Integer costoHora) {
        this.costoHora = costoHora;
    }

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
}
