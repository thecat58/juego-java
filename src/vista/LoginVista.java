package vista;

import java.util.Scanner;

public class LoginVista {

    public String[] mostrarLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();
        return new String[]{usuario, contrasena};
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
