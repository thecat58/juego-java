package Vista;

import java.util.Scanner;

public class LoginVista {
    private Scanner scanner;

    public LoginVista() {
        scanner = new Scanner(System.in);
    }

    public String[] mostrarLogin() {
        System.out.println("Ingrese su nombre de usuario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();
        return new String[]{nombre, password};
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}