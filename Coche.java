package org.example;

public class Coche extends Vehiculo {
    private int puertas;

    public Coche(String matricula, double precioDia, int puertas) {
        super(matricula, precioDia);
        this.puertas = puertas;
    }

    @Override
    public double calcularAlquiler(int dias) {
        double total = this.precioDia * dias;
        if (puertas > 3) total += 15; // Plus por comodidad
        return total;
    }

    @Override
    public String toString() {
        return "COCHE -> Matrícula: " + matricula + " | Puertas: " + puertas + " | Alquilado: " + alquilado;
    }
}