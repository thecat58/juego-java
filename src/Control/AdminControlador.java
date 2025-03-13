package Controlador;

import Vista.AdminVista;

public class AdminControlador {
    private AdminVista adminVista;

    public AdminControlador(AdminVista adminVista) {
        this.adminVista = adminVista;
    }

    public void iniciar() {
        int opcion;
        do {
            adminVista.mostrarMenuAdmin();
            opcion = adminVista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    adminVista.mostrarMensaje("Editar poderes no implementado aún.");
                    break;
                case 2:
                    adminVista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    adminVista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 2);
    }
}