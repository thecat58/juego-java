/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aventuras;

import Modelo.Usuario;
import Modelo.ListarUsuario;
import vista.LoginVista;

public class LoginControlador {
    private ListarUsuario ListarUsuario;
    private LoginVista loginVista;

    public LoginControlador(ListarUsuario ListarUsuario, LoginVista loginVista) {
        this.ListarUsuario = ListarUsuario;
        this.loginVista = loginVista;
    }

    public Usuario autenticar() {
        String[] credenciales = loginVista.mostrarLogin();
        Usuario usuario = ListarUsuario.autenticar(credenciales[0], credenciales[1]);
        if (usuario != null) {
            loginVista.mostrarMensaje("Autenticación exitosa. Bienvenido " + usuario.getNombre());
        } else {
            loginVista.mostrarMensaje("Autenticación fallida. Intente de nuevo.");
        }
        return usuario;
    }
}