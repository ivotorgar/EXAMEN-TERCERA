package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa rentACar = new Empresa();
        Scanner sc = new Scanner(System.in);

        // Datos de prueba iniciales
        rentACar.registrarCliente(new Cliente("123A", "Juan"));
        rentACar.agregarVehiculo(new Coche("ABC-123", 40.0, 5));

        int opcion;
        do {
            System.out.println("\n--- RENT A CAR ---");
            System.out.println("1. Alquilar Vehículo");
            System.out.println("2. Listar Alquileres");
            System.out.println("3. Salir");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("DNI Cliente: "); String dni = sc.next();
                System.out.print("Matrícula: "); String mat = sc.next();
                System.out.print("Días: "); int dias = sc.nextInt();
                if (rentACar.realizarAlquiler(dni, mat, dias)) {
                    System.out.println("Éxito!");
                } else {
                    System.out.println("Error: Cliente o vehículo no válidos.");
                }
            }
        } while (opcion != 3);
    }
}