package aventuras;

import Control.AdminControlador;
import Control.JugadorControlador;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import vista.AdminVista;
import vista.LoginVista;
import Modelo.Arma;
import Modelo.Guerrero;
import Modelo.Llave;
import Modelo.Mago;
import Modelo.Pocion;
import Vista.JugadorVista;

import java.util.Scanner;

public class Aventuras {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LoginVista loginVista = new LoginVista();
        LoginControlador loginControlador = new LoginControlador(usuarioDAO, loginVista);

        Usuario usuario = loginControlador.autenticar();
        if (usuario != null) {
            if (usuario.getRol().equals("admin")) {
                AdminVista adminVista = new AdminVista();
                AdminControlador adminControlador = new AdminControlador(adminVista);
                adminControlador.iniciar();
            } else if (usuario.getRol().equals("jugador")) {
                JugadorVista jugadorVista = new JugadorVista();
                JugadorControlador jugadorControlador = new JugadorControlador(jugadorVista);
                jugadorControlador.iniciar();
                iniciarJuego();
            }
        }
    }

    public static void iniciarJuego() {
        Guerrero ObjGuerrero = new Guerrero("Arturo");
        Mago ObjMago = new Mago("Merlin");
        Arma ObjArma = new Arma("Espada", 30);
        Pocion ObjPocion = new Pocion("Pocion", 40);
        Llave ObjLlave = new Llave("Maestra");
        Scanner t = new Scanner(System.in);

        System.out.println("AVENTURAS \n");
        System.out.println("Ingrese la opcion que desea realizar: ");
        System.out.println("1. JUGAR ");
        System.out.println("2. SALIR \n");

        int opcion = t.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Bienvenido Guerrero!!! ");
                System.out.println("El mago tiene una pocion y una llave");
                System.out.println("Debes derrotarlo para abrir la puerta!!! ");

                ObjGuerrero.agregarObjeto(ObjArma);
                ObjGuerrero.agregarObjeto(ObjPocion);

                while (ObjMago.getVida() > 0 && ObjGuerrero.getVida() > 0) {
                    System.out.println("\nSelecciona el objeto que deseas usar: ");
                    System.out.println("1. Espada");
                    System.out.println("2. Pocion");

                    int seleccion = t.nextInt();
                    if (seleccion == 1) {
                        ObjGuerrero.atacar(ObjMago, ObjArma);
                    } else if (seleccion == 2) {
                        ObjGuerrero.usarObjeto(ObjPocion);
                    }

                    System.out.println("\nVida de " + ObjMago.getNombre() + ": " + ObjMago.getVida());
                    System.out.println("Energia de " + ObjMago.getNombre() + ": " + ObjMago.getEnergia());

                    if (ObjMago.getVida() > 0) {
                        ObjMago.atacar(ObjGuerrero, ObjLlave);
                        System.out.println("\n!!! Oh noo " + ObjMago.getNombre() + " lanzo un hechizo a tu guerrero!!!");
                        System.out.println("Vida del guerrero: " + ObjGuerrero.getVida());
                        System.out.println("Energia del guerrero: " + ObjGuerrero.getEnergia());
                    }
                }

                if (ObjGuerrero.getVida() > 0) {
                    System.out.println("\nFELICITACIONES!!! HAS DERROTADO AL MAGO!!!");
                } else {
                    System.out.println("\nHAS SIDO DERROTADO!!!");
                }
                break;

            case 2:
                System.out.println("Saliendo del juego...");
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}




