package vista;

import java.util.Scanner;

public class AdminVista {
    private Scanner scanner;

    public AdminVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuAdmin() {
        System.out.println("Menú Admin:");
        System.out.println("1. Editar poderes");
        System.out.println("2. Salir");
    }

    public int obtenerOpcion() {
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}