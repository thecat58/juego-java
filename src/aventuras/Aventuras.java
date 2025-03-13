package aventuras;

import Controlador.AdminControlador;
import Controlador.JugadorControlador;
import Controlador.LoginControlador;
import Modelo.Usuario;
import Vista.AdminVista;
import Vista.JugadorVista;
import Vista.LoginVista;
import Modelo.Arma;
import Modelo.Guerrero;
import Modelo.Llave;
import Modelo.Mago;
import Modelo.Objeto;
import Modelo.Pocion;
import Modelo.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
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
                jugadorControlador.iniciar(); // iniciarJuego() será llamado desde JugadorControlador
            }
            
        }
    }

    public static void iniciarJuego() {
        Guerrero ObjGuerrero = new Guerrero("Arturo");
        Mago ObjMago = new Mago("Merlin");
        Arma ObjArma = new Arma("Espada", 30);
        List<Objeto> Objeto = new ArrayList<>();
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

                for (Objeto objeto : ObjGuerrero.getInventario()) {
                    if (objeto.getClass() == Arma.class) {
                        Objeto.add(objeto);
                    }
                }
                do {
                    System.out.println("");
                    System.out.println("Selecciona el objeto que deseas usar: ");
                    for (Objeto obj : ObjGuerrero.getInventario()) {
                        System.out.println(ObjGuerrero.getInventario().indexOf(obj) + 1 + ". " + obj.getNombre());
                    }
                    int op3 = t.nextInt();
                    if (op3 == 1) {
                        if (ObjGuerrero.getEnergia() > 20) {
                            ObjGuerrero.atacar(ObjMago, ObjArma);
                            System.out.println("\nVida de Merlin: " + ObjMago.getVida() + "\nEnergia de Merlin: " + ObjMago.getEnergia());
                            if (ObjMago.getVida() <= 0) {
                                ObjMago.getInventario().remove(ObjLlave);
                                ObjGuerrero.agregarObjeto(ObjLlave);
                                if (ObjLlave.abrir(ObjGuerrero) == true) {
                                    System.out.println("\nHas derrotado a Merlin !!! ");
                                    System.out.println("Puedes tomar la llave para abrir la puerta y pasar al siguiente nivel");
                                }
                            } else {
                                if (ObjGuerrero.getVida() >= 0) {
                                    if (ObjMago.getEnergia() > 10) {
                                        ObjMago.atacar(ObjGuerrero, ObjArma);
                                        System.out.println("\nVida del guerrero: " + ObjGuerrero.getVida() + "\nEnergia del guerrero: " + ObjGuerrero.getEnergia());
                                    } else {
                                        System.out.println("\nMerlin no puede lanzar un hechizo por que no tiene energia");
                                    }
                                } else {
                                    System.out.println("\nEl ganador es : " + ObjMago.getNombre());
                                }
                            }
                        } else {
                            System.out.println("!!! No tienes suficiente energia para atacar !!!");
                            System.out.println("Debes tomar la pocion para recuperarte");
                        }
                    } else {
                        ObjGuerrero.usarObjeto(ObjPocion);
                        System.out.println("Has aumentado tu energia!!! ");
                        System.out.println("Puedes atacar de nuevo");
                    }
                } while ((ObjMago.getVida() > 0) || (ObjGuerrero.getVida() > 0));
                break;
            default:
        }
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}