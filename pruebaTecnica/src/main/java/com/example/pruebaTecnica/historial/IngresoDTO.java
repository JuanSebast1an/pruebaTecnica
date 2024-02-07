package com.example.pruebaTecnica.historial;

import com.example.pruebaTecnica.parqueadero.Parqueadero;
import com.example.pruebaTecnica.vehiculo.Vehiculo;

public class IngresoDTO {
    private Historial historial;
    private Vehiculo vehiculo;

    private Parqueadero parqueadero;

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
