package Control;

import vista.AdminVista;
import Modelo.Guerrero;
import Modelo.Mago;
import Modelo.Arma;

public class AdminControlador {
    private AdminVista adminVista;
    private Guerrero guerrero;
    private Mago mago;
    private Arma arma;

    public AdminControlador(AdminVista adminVista) {
        this.adminVista = adminVista;
        this.guerrero = new Guerrero("Arturo");
        this.mago = new Mago("Merlin");
        this.arma = new Arma("Espada", 30);
    }

    public void iniciar() {
        int opcion;
        do {
            adminVista.mostrarMenuAdmin();
            opcion = adminVista.obtenerOpcion();
            switch (opcion) {
                case 1:
                    editarPoderes();
                    break;
                case 2:
                    adminVista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    adminVista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 2);
    }

    private void editarPoderes() {
        adminVista.mostrarMensaje("Editar poderes:");
        adminVista.mostrarMensaje("1. Editar vida del guerrero");
        adminVista.mostrarMensaje("2. Editar energía del guerrero");
        adminVista.mostrarMensaje("3. Editar vida del mago");
        adminVista.mostrarMensaje("4. Editar energía del mago");
        adminVista.mostrarMensaje("5. Editar daño del arma");
        int opcion = adminVista.obtenerOpcion();
        switch (opcion) {
            case 1:
                adminVista.mostrarMensaje("Ingrese la nueva vida del guerrero:");
                int vidaGuerrero = adminVista.obtenerOpcion();
                guerrero.setVida(vidaGuerrero);
                adminVista.mostrarMensaje("Vida del guerrero actualizada.");
                break;
            case 2:
                adminVista.mostrarMensaje("Ingrese la nueva energía del guerrero:");
                int energiaGuerrero = adminVista.obtenerOpcion();
                guerrero.setEnergia(energiaGuerrero);
                adminVista.mostrarMensaje("Energía del guerrero actualizada.");
                break;
            case 3:
                adminVista.mostrarMensaje("Ingrese la nueva vida del mago:");
                int vidaMago = adminVista.obtenerOpcion();
                mago.setVida(vidaMago);
                adminVista.mostrarMensaje("Vida del mago actualizada.");
                break;
            case 4:
                adminVista.mostrarMensaje("Ingrese la nueva energía del mago:");
                int energiaMago = adminVista.obtenerOpcion();
                mago.setEnergia(energiaMago);
                adminVista.mostrarMensaje("Energía del mago actualizada.");
                break;
            case 5:
                adminVista.mostrarMensaje("Ingrese el nuevo daño del arma:");
                int danoArma = adminVista.obtenerOpcion();
                arma.setDano(danoArma);
                adminVista.mostrarMensaje("Daño del arma actualizado.");
                break;
            default:
                adminVista.mostrarMensaje("Opción no válida.");
        }
    }
}