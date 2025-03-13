package vista;

import java.util.Scanner;

public class JugadorVista {
    private Scanner scanner;

    public JugadorVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuJugador() {
        System.out.println("Menú Jugador:");
        System.out.println("1. Jugar");
        System.out.println("2. Salir");
    }

    public int obtenerOpcion() {
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}