package org.example;

public class Alquiler {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;
    private double precioTotal;

    public Alquiler(Cliente cliente, Vehiculo vehiculo, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.precioTotal = vehiculo.calcularAlquiler(dias);
    }

    @Override
    public String toString() {
        return "ALQUILER: " + cliente + " | Vehículo: " + vehiculo.getMatricula() +
                " | Días: " + dias + " | Total: " + precioTotal + "€";
    }
}