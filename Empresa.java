package org.example;

import java.util.*;

public class Empresa {
    private ArrayList<Vehiculo> flota = new ArrayList<>();
    private Set<Cliente> clientes = new HashSet<>();
    private LinkedList<Alquiler> historial = new LinkedList<>();

    public void agregarVehiculo(Vehiculo v) { flota.add(v); }

    public boolean registrarCliente(Cliente c) { return clientes.add(c); }

    public Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) return c;
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String matricula) {
        for (Vehiculo v : flota) {
            if (v.getMatricula().equalsIgnoreCase(matricula)) return v;
        }
        return null;
    }

    public boolean realizarAlquiler(String dni, String matricula, int dias) {
        Cliente c = buscarCliente(dni);
        Vehiculo v = buscarVehiculo(matricula);

        if (c != null && v != null && !v.isAlquilado()) {
            v.alquilar(dias);
            Alquiler nuevo = new Alquiler(c, v, dias);
            historial.add(nuevo);
            return true;
        }
        return false;
    }

    public void listarAlquileres() {
        for (Alquiler a : historial) System.out.println(a);
    }
}