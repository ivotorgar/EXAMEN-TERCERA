package org.example;

public abstract class Vehiculo implements Alquilable {
    protected String matricula;
    protected double precioDia;
    protected boolean alquilado;

    public Vehiculo(String matricula, double precioDia) {
        this.matricula = matricula;
        this.precioDia = precioDia;
        this.alquilado = false;
    }

    public String getMatricula() { return matricula; }
    public boolean isAlquilado() { return alquilado; }

    // Método abstracto que cada hijo implementará a su manera (Polimorfismo)
    public abstract double calcularAlquiler(int dias);

    @Override
    public boolean alquilar(int dias) {
        if (!alquilado) {
            this.alquilado = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean devolver() {
        if (alquilado) {
            this.alquilado = false;
            return true;
        }
        return false;
    }
}