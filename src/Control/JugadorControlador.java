package Controlador;

import Vista.JugadorVista;
import aventuras.Aventuras; 
public class JugadorControlador {
    private JugadorVista jugadorVista;

    public JugadorControlador(JugadorVista jugadorVista) {
        this.jugadorVista = jugadorVista;
    }

    public void iniciar() {
        int opcion;
        do {
            jugadorVista.mostrarMenuJugador();
            opcion = jugadorVista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    jugadorVista.mostrarMensaje("Iniciando juego...");
                    Aventuras.iniciarJuego(); // Llamada directa desde aquí
                    break;
                case 2:
                    jugadorVista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    jugadorVista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 2);
    }
}
