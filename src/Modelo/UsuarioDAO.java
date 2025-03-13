package Modelo;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
        // Agregar usuarios de ejemplo
        usuarios.add(new Usuario("admin", "admin123", "admin"));
        usuarios.add(new Usuario("jugador", "jugador123", "jugador"));
    }

    public Usuario autenticar(String nombre, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}