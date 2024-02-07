package com.example.pruebaTecnica.vehiculo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table
@Builder
public class Vehiculo {


    @Id
    private String placa;
    private String estado;

    public Vehiculo(String placa, String estado) {
        this.placa = placa;
        this.estado = estado;
    }


    public Vehiculo() {

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
