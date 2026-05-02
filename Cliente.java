package org.example;

import java.util.Objects;

public class Cliente {
    private String dni;
    private String nombre;

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() { return dni; }

    @Override
    public String toString() { return "Cliente: " + nombre + " (" + dni + ")"; }

    // Esto permite que el Set detecte que dos clientes son el mismo por su DNI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() { return Objects.hash(dni); }
}